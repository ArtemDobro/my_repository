import urllib.request
# from tqdm.notebook import tqdm
import requests
from bs4 import BeautifulSoup


# получаем информацию о каннском
def get_cannes():
    url = f'https://www.kinopoisk.ru/awards/cannes/'
    response_palm = requests.get(url)
    soup_palm = BeautifulSoup(response_palm.content, 'html.parser')
    from collections import defaultdict

    year_to_films_palm = defaultdict(set)
    films_html_block_palm = soup_palm.find_all('tr')
    films_info_palm = films_html_block_palm[9:]
    years_palm = []
    urls_palm = []
    countries_palm = []
    names_palm = []

    class CurrentFilm:
        def __init__(self, url):
            self.film_response = requests.get(url)
            self.film_soup = BeautifulSoup(self.film_response.content, 'html.parser')

        def get_country(self):
            country = self.film_soup.find_all('a', 'styles_linkDark__3aytH styles_link__1N3S2')[1].text
            return country

        # @staticmethod
        # def from_excel_path(excel_path: str):
        #     return CurrentFilm(
        #         pd.read_excel(excel_path),
        #     )

    films_html_block_palm = soup_palm.find_all('tr')
    films_info_palm = films_html_block_palm[9:]
    for tag in films_info_palm:
        year = tag.a.text
        films_of_year = tag.find_all('a', 'all')
        for film in films_of_year:
            url = f'https://www.kinopoisk.ru{film["href"]}'
            name = film.text
            years_palm.append(year)
            urls_palm.append(url)
            names_palm.append(name)
            # film_response = requests.get(url, headers={'User-Agent': UserAgent().chrome})
            # film_soup = BeautifulSoup(film_response.content, 'html.parser')
            # country = film_soup.find_all('a','styles_linkDark__3aytH styles_link__1N3S2')[1].text
            # countries.append(country)
            year_to_films_palm[year].add(url)
    return year_to_films_palm


# получаем последние новости
def get_news():
    response_art = requests.get('https://kinoart.ru')
    soup_art = BeautifulSoup(response_art.content, 'html.parser')

    html_blocks_art = soup_art.find_all('div', "_3_L2e")
    html_tags_href = html_blocks_art[0].find_all('a')

    recent_news = []

    for tag in html_tags_href[:-1]:
        recent_news.append(f'https://kinoart.ru{tag["href"]}')
    return recent_news

import telebot
from telebot import types
from my1 import *
import my1

bot = telebot.TeleBot("TOKEN")

year_to_films_cannes = {}
year_to_films_venice = {}
year_to_countries_venice = {}
year_to_genres_venice = {}


# получаем информацию о венециаском
def get_venice():
    response_lion = requests.get('https://www.kinopoisk.ru/lists/festivals/labiennale/golden-lion/?tab=all')
    soup_lion = BeautifulSoup(response_lion.content, 'html.parser')
    # print(soup_lion.prettify())
    films_blocks_lion = soup_lion.find_all('td')[17:78]
    # print(films_blocks_lion)

    years_lion = []
    urls_lion = []
    countries_lion = []
    names_lion = []
    genres_lion = []
    global year_to_films_venice
    global year_to_countries_venice
    global year_to_genres_venice
    names_html_block_lion = soup_lion.find_all('p', 'selection-film-item-meta__name')
    urls_html_block_lion = soup_lion.find_all('a', 'selection-film-item-meta__link')
    years_html_block_lion = soup_lion.find_all('p', 'selection-film-item-meta__original-name')
    countries_genres_html_block_lion = soup_lion.find_all('span', 'selection-film-item-meta__meta-additional-item')
    for tag in names_html_block_lion:
        names_lion.append(tag.text)
    for tag in urls_html_block_lion:
        urls_lion.append(f'https://www.kinopoisk.ru{tag["href"]}')
    for tag in years_html_block_lion:
        years_lion.append(tag.text[-4:])
    for tag in countries_genres_html_block_lion[::2]:
        countries_lion.append(tag.text)
    for tag in countries_genres_html_block_lion[1::2]:
        genres_lion.append(tag.text)
    year_to_films_venice = dict(zip(years_lion, urls_lion))
    year_to_countries_venice = dict(zip(years_lion, countries_lion))
    year_to_genres_venice = dict(zip(years_lion, genres_lion))


@bot.message_handler(func = lambda m: True)
def echo_all(message):
    if message.text == '/start':
        bot.send_message(message.from_user.id, "Привет!Как тебя зовут?")
        bot.register_next_step_handler(message, choice)


def choice(message):
    keyboard = types.InlineKeyboardMarkup()
    key_venice = types.InlineKeyboardButton(text = 'Узнать о Веницианском кинофестивале',
                                            callback_data = 'venice')
    keyboard.add(key_venice)
    key_cannes = types.InlineKeyboardButton(text = 'Узнать о Каннском кинофестивале',
                                            callback_data = 'cannes')
    keyboard.add(key_cannes)
    key_news = types.InlineKeyboardButton(text = 'Узнать последние новости кино', callback_data = 'news')
    keyboard.add(key_news)
    question = "Что тебя интересует?"
    bot.send_message(message.from_user.id, text = question, reply_markup = keyboard)


@bot.callback_query_handler(func = lambda call: True)
def callback_worker(call):
    if call.data == "venice":
        get_venice()
        bot.send_message(call.message.chat.id, "Какой год интересует?")
        bot.register_next_step_handler(call.message, choice_year_venice)
    elif call.data == "cannes":
        bot.send_message(call.message.chat.id, "Какой год интересует?")
        global year_to_films_cannes
        year_to_films_cannes = get_cannes()
        bot.register_next_step_handler(call.message, choice_year_cannes)
    elif call.data == "news":
        for news in get_news():
            bot.send_message(call.message.chat.id, news)


def choice_year_cannes(message):
    year = message.text
    if year not in year_to_films_cannes.keys():
        bot.send_message(message.from_user.id, "в этот год ничего не вручали")
        return
    for url in year_to_films_cannes.get(year):
        bot.send_message(message.from_user.id, url)


def choice_year_venice(message):
    year = message.text
    if year not in year_to_films_venice.keys():
        bot.send_message(message.from_user.id, "в этот год ничего не вручали")
        return
    bot.send_message(message.from_user.id, year_to_countries_venice.get(year))
    bot.send_message(message.from_user.id, year_to_genres_venice.get(year))
    bot.send_message(message.from_user.id, year_to_films_venice.get(year))


bot.polling()

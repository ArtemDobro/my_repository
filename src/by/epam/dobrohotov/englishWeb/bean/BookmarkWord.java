package by.epam.dobrohotov.englishWeb.bean;

import java.util.List;
import java.util.Objects;

public class BookmarkWord {

    private List<String> words;
    public BookmarkWord(List<String> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookmarkWord bookmark = (BookmarkWord) o;
        return Objects.equals(words, bookmark.words);
    }

    @Override
    public String toString() {
        return "BookmarkWord{" +
                "words=" + words +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }


}

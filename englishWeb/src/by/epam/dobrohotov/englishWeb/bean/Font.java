package by.epam.dobrohotov.englishWeb.bean;

import java.util.HashMap;
import java.util.Objects;

public class Font extends Purchase{
    private HashMap<String,Integer> fontToCost;

    public Font(HashMap<String, Integer> fontToCost) {
        this.fontToCost = fontToCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Font newFont = (Font) o;
        return Objects.equals(fontToCost, newFont.fontToCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fontToCost);
    }

    @Override
    public String toString() {
        return "Font{" +
                "fontToCost=" + fontToCost +
                '}';
    }

    public HashMap<String, Integer> getFontToCost() {
        return fontToCost;
    }

    public void setFontToCost(HashMap<String, Integer> fontToCost) {
        this.fontToCost = fontToCost;
    }
}

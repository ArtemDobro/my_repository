package by.epam.dobrohotov.englishWeb.bean;

import java.util.Objects;

public class Feedback {
    private String text;
    private int mark;

    public Feedback(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return mark == feedback.mark && Objects.equals(text, feedback.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, mark);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}

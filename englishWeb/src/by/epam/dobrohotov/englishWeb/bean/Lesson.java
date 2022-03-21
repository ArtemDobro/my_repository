package by.epam.dobrohotov.englishWeb.bean;

import java.util.Objects;

public class Lesson {

  private String text;
  private int countOfWords;

  public Lesson(String text, int countOfWords) {
    this.text = text;
    this.countOfWords = countOfWords;
  }

  public Lesson(String text) {
    this.text = text;
    this.countOfWords = getCountOfWords();
  }

  public int getCountOfWords() {
    if (countOfWords == 0) {
      countOfWords = this.text.split("\\s+").length;
    }
    return countOfWords;
  }

  @Override
  public String toString() {
    return "Lesson{" +
        "text='" + text + '\'' +
        ", countOfWords=" + countOfWords +
        '}';
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Lesson lesson = (Lesson) o;
    return countOfWords == lesson.countOfWords && Objects.equals(text, lesson.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, countOfWords);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setCountOfWords(int countOfWords) {
    this.countOfWords = countOfWords;
  }
}

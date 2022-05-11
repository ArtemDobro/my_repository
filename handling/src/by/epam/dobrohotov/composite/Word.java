package by.epam.dobrohotov.composite;

import java.util.ArrayList;
import java.util.List;

public class Word extends TextComponent{
  int vowelNumber;
  int consonantNumber;
  String text;

  public Word(String text) {
    this.text = text;
  }

  public int getVowelNumber() {
    return vowelNumber;
  }

  public int getConsonantNumber() {
    return consonantNumber;
  }

  public String getText() {
    return text;
  }

}

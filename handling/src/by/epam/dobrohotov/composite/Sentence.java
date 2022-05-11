package by.epam.dobrohotov.composite;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends TextComponent{
  List<TextComponent> wordsComponents = new ArrayList<>();
  int wordsNumber;
  String text;

  public Sentence(String text) {
    this.text = text;
  }

  public Sentence(List<TextComponent> wordsComponents) {
    this.wordsComponents = wordsComponents;
  }

  public TextComponent getChild(int i) {
    return wordsComponents.get(i);
  }

  public int getWordsNumber() {
    return wordsNumber;
  }

  public String getText() {
    return text;
  }
}

package by.epam.dobrohotov.composite;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends TextComponent {

  List<TextComponent> sentencesComponents = new ArrayList<>();
  int sentencesNumber;
  String text;

  public Paragraph(List<TextComponent> sentencesComponents) {
    this.sentencesComponents = sentencesComponents;
  }

  public Paragraph(String text) {
    this.text = text;
  }

  public TextComponent getChild(int i) {
    return sentencesComponents.get(i);
  }

  public int getSentencesNumber() {
    return sentencesNumber;
  }

  public String getText() {
    return text;
  }
}

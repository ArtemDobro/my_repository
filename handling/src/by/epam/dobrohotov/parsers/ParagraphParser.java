package by.epam.dobrohotov.parsers;

import static by.epam.dobrohotov.utils.Constants.SENTENCE_GENEREX;

import by.epam.dobrohotov.composite.Paragraph;
import by.epam.dobrohotov.composite.TextComponent;
import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends  Middleware{

  @Override
  public TextComponent parse(String text) {
    List<TextComponent> sentencesComponent = new ArrayList<>();
    List<String> sentencesString = List.of(text.split(SENTENCE_GENEREX));
    for(String sentenceStr : sentencesString ){
      sentencesComponent.add(parseNext(sentenceStr));
    }
    return new Paragraph(sentencesComponent);
  }
}

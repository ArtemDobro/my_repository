package by.epam.dobrohotov.parsers;

import static by.epam.dobrohotov.utils.Constants.SENTENCE_GENEREX;
import static by.epam.dobrohotov.utils.Constants.WORD_GENEREX;

import by.epam.dobrohotov.composite.Paragraph;
import by.epam.dobrohotov.composite.Sentence;
import by.epam.dobrohotov.composite.TextComponent;
import by.epam.dobrohotov.composite.Word;
import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends Middleware{

  @Override
  public TextComponent parse(String text) {
    List<TextComponent> wordsComponent = new ArrayList<>();
    List<String> wordsString = List.of(text.split(WORD_GENEREX));
    for(String wordStr : wordsString ){
      wordsComponent.add(new Word(wordStr));
    }
    return new Sentence(wordsComponent);
  }
}

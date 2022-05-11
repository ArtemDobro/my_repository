package by.epam.dobrohotov.parsers;

import static by.epam.dobrohotov.utils.Constants.PARAGRAPH_GENEREX;

import by.epam.dobrohotov.composite.AllText;
import by.epam.dobrohotov.composite.TextComponent;
import java.util.ArrayList;
import java.util.List;

public class AllTextParser extends Middleware{
  @Override
  public TextComponent parse(String text) {
    List<TextComponent> paragraphsComponent = new ArrayList<>();
    List<String> paragraphsString = List.of(text.split(PARAGRAPH_GENEREX));;
    for(String paragraphStr : paragraphsString){
      paragraphsComponent.add(parseNext(paragraphStr));
    }
    return new AllText(paragraphsComponent);

  }
}

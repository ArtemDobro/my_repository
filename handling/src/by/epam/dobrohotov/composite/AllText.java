package by.epam.dobrohotov.composite;

import java.util.ArrayList;
import java.util.List;

public class AllText extends TextComponent {

  List<TextComponent> paragraphsComponents = new ArrayList<>();

  public AllText(List<TextComponent> paragraphsComponents) {
    this.paragraphsComponents = paragraphsComponents;
  }

  public TextComponent getChild(int i) {
    return paragraphsComponents.get(i);
  }
}

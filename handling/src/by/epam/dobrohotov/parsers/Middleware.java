package by.epam.dobrohotov.parsers;

import by.epam.dobrohotov.composite.TextComponent;
import java.util.List;

public abstract class Middleware {

  private Middleware next;

  public Middleware linkWith(Middleware next) {
    this.next = next;
    return next;
  }

  public abstract TextComponent parse(String text);

  protected TextComponent parseNext(String text) {
    if (next != null) {
      return next.parse(text);
    } else {
      throw new UnsupportedOperationException("next Middleware is not exist");
    }
  }
}

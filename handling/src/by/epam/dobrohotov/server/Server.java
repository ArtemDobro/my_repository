package by.epam.dobrohotov.server;

import by.epam.dobrohotov.composite.TextComponent;
import by.epam.dobrohotov.parsers.Middleware;

public class Server {
  TextComponent parsedText;
  private Middleware middleware;

  public void setMiddleware(Middleware middleware) {
    this.middleware = middleware;
  }
  public void parseAllText(String text){
    parsedText = middleware.parse(text);
  }

}

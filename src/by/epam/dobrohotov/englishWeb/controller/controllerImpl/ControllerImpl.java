package by.epam.dobrohotov.englishWeb.controller.controllerImpl;

import by.epam.dobrohotov.englishWeb.controller.CommandProvider;
import by.epam.dobrohotov.englishWeb.controller.Controller;
import by.epam.dobrohotov.englishWeb.controller.commands.Command;
import by.epam.dobrohotov.englishWeb.presentation.View;
import java.io.IOException;
import java.util.List;

public class ControllerImpl implements Controller {

  private CommandProvider provider = new CommandProvider();

  @Override
  public View doAction(List<String> request) throws IOException {
    String[] params;
    String commandName;
    commandName = request.get(0);
    Command currentCommand = provider.getCommand(commandName);
    View response;
    response = currentCommand.execute(request);
    return response;
  }
}

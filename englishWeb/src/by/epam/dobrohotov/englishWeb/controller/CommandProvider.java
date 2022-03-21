package by.epam.dobrohotov.englishWeb.controller;

//import by.epam.dobrohotov.controller.commands.*;
import by.epam.dobrohotov.englishWeb.controller.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();
    public CommandProvider(){
        commands.put("logination user", new LoginationUserCommand());
        commands.put("logination admin", new LoginationAdminCommand());
        commands.put("registration user", new RegistrationUserCommand());
        commands.put("registration admin", new RegistrationAdminCommand());
        commands.put("add Lesson", new AddLessonCommand());
    }
    public Command getCommand(String commandName){
        Command command;
        command = commands.get(commandName);
        return command;
    }
}

package by.epam.dobrohotov.englishWeb.controller.commands;

import by.epam.dobrohotov.englishWeb.service.ServiceProvider;
import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.presentation.View;
import by.epam.dobrohotov.englishWeb.presentation.ViewImpl.LoginationUserCommandView;
import by.epam.dobrohotov.englishWeb.service.UserService;
import java.util.List;

public class LoginationUserCommand implements Command {
    @Override
    public View execute(List<String> params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String login = params.get(1);
        String password = params.get(2);
        Person personResult = userService.signIn(login,password);
        return new LoginationUserCommandView(personResult);
    }
}

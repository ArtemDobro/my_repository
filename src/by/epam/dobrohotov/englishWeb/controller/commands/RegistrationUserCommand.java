package by.epam.dobrohotov.englishWeb.controller.commands;

import by.epam.dobrohotov.englishWeb.service.ServiceProvider;
import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.presentation.View;
import by.epam.dobrohotov.englishWeb.presentation.ViewImpl.RegistrationUserCommandView;
import by.epam.dobrohotov.englishWeb.service.UserService;
import java.util.List;

public class RegistrationUserCommand implements Command {
    @Override
    public View execute(List<String> params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        String name = params.get(1);
        int age = Integer.parseInt(params.get(2));
        String login = params.get(3);
        String password = params.get(4);
        Person person = new Person.PersonBuilder().name(name).age(age).login(login).password(password).build();
        try {
            userService.registration(person);

        } catch (Exception ex) {
            return new RegistrationUserCommandView("Exception");
        }
        return new RegistrationUserCommandView("all good");
    }
}

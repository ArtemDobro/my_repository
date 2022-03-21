package by.epam.dobrohotov.englishWeb.controller.commands;

import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.presentation.View;
import by.epam.dobrohotov.englishWeb.presentation.ViewImpl.LoginationAdminCommandView;
import by.epam.dobrohotov.englishWeb.service.AdminService;
import by.epam.dobrohotov.englishWeb.service.ServiceProvider;
import java.util.List;

public class LoginationAdminCommand implements Command {
    @Override
    public View execute(List<String> params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        AdminService adminService = provider.getAdminService();

        String login = params.get(1);
        String password = params.get(2);
        Person personResult = adminService.signIn(login,password);
        return new LoginationAdminCommandView(personResult);
    }
}

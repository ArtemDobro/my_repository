package by.epam.dobrohotov.englishWeb.service.impl;

import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.dao.AdminDAO;
import by.epam.dobrohotov.englishWeb.dao.DAOProvider;
import by.epam.dobrohotov.englishWeb.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public Person signIn(String login, String password) {
        AdminDAO adminDAO = provider.getAdminDAO();
        return adminDAO.signIn(login, password);
    }

    @Override
    public void registration(Person person) {
        AdminDAO adminDAO = provider.getAdminDAO();
        adminDAO.registrate(person);
    }
}

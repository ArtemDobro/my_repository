package by.epam.dobrohotov.englishWeb.service.impl;

import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.dao.UserDAO;
import by.epam.dobrohotov.englishWeb.service.UserService;
import by.epam.dobrohotov.englishWeb.dao.DAOProvider;

public class UserServiceImpl implements UserService {
    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public Person signIn(String login, String password) {
        UserDAO userDAO = provider.getUserDAO();
        return userDAO.signIn(login, password);
    }

//    @Override
//    public void signOut(String login) {
//
//    }

    @Override
    public void registration(Person person) {
        UserDAO userDAO = provider.getUserDAO();
        userDAO.registrate(person);
    }
}

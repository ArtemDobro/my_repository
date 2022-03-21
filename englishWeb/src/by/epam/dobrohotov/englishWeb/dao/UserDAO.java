package by.epam.dobrohotov.englishWeb.dao;

import by.epam.dobrohotov.englishWeb.bean.Person;

public interface UserDAO {
    Person signIn(String login, String password);
    void registrate(Person person);
}

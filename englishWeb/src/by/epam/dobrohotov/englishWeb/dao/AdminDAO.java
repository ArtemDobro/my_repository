package by.epam.dobrohotov.englishWeb.dao;

import by.epam.dobrohotov.englishWeb.bean.Person;

public interface AdminDAO {
    Person signIn(String login, String password);
    void registrate(Person person);
}

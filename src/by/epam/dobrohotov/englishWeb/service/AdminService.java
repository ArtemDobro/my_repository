package by.epam.dobrohotov.englishWeb.service;

import by.epam.dobrohotov.englishWeb.bean.Person;

public interface AdminService {
    Person signIn(String login, String password);
    void registration(Person person);
}

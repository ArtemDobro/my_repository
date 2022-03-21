package by.epam.dobrohotov.englishWeb.service;

import by.epam.dobrohotov.englishWeb.bean.Person;

public interface UserService {
    Person signIn(String login, String password);
//    void addWord(String word);
//    void signOut(String login);
    void registration(Person person);
}

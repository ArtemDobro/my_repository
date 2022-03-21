package by.epam.dobrohotov.englishWeb.dao.impl;

import by.epam.dobrohotov.englishWeb.dao.DataSource;
import by.epam.dobrohotov.englishWeb.dao.UserDAO;
import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.utils.GenericTuple;

public class StorageUserDAO implements UserDAO {
    private final DataSource dataSource = DataSource.getInstance();
    @Override
    public Person signIn(String login, String password) {
        GenericTuple<String,String> pair = new GenericTuple<>(login,password);
        Person p = dataSource.getMapUsers().get(pair);
        return dataSource.getMapUsers().get(pair);
    }

    @Override
    public void registrate(Person person) {
        GenericTuple<String,String> pair = new GenericTuple<>(person.getLogin(),person.getPassword());
        dataSource.getMapUsers().put(pair,person);
    }
}

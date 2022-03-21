package by.epam.dobrohotov.englishWeb.dao.impl;

import by.epam.dobrohotov.englishWeb.dao.AdminDAO;
import by.epam.dobrohotov.englishWeb.dao.DataSource;
import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.utils.GenericTuple;

public class StorageAdminDAO implements AdminDAO {
    private final DataSource dataSource = DataSource.getInstance();
    @Override
    public Person signIn(String login, String password) {
        GenericTuple<String,String> pair = new GenericTuple<>(login,password);
        Person p = dataSource.getMapAdmins().get(pair);
        return dataSource.getMapAdmins().get(pair);
    }

    @Override
    public void registrate(Person person) {
        GenericTuple<String,String> pair = new GenericTuple<>(person.getLogin(),person.getPassword());
        dataSource.getMapAdmins().put(pair,person);
    }
}

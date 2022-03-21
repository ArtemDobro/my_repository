package by.epam.dobrohotov.englishWeb.dao;

import by.epam.dobrohotov.englishWeb.bean.Lesson;
import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.utils.GenericTuple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataSource {
    private Map<GenericTuple<String, String>,Person> mapUsers = new HashMap<>();
    private Map<GenericTuple<String, String>,Person> mapAdmins = new HashMap<>();
    private Set<Lesson> lessons = new HashSet<>();
    private DataSource(){}
    private static DataSource instance= new DataSource();
    public static DataSource getInstance(){
        return instance;
    }

    public Map<GenericTuple<String, String>,Person> getMapUsers() {

        return mapUsers;
    }

    public Map<GenericTuple<String, String>,Person> getMapAdmins() {
        return mapAdmins;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }
}

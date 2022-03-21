package by.epam.dobrohotov.englishWeb.bean;

import java.util.HashMap;
import java.util.List;

public class User extends Person {
    private String city;
    private int levelOfKnowledge;
    private Feedback feedback;
    private int coins;
    private HashMap<String,String> dictionary;
    private List<BookmarkWord> bookmarks;
    private List<Purchase> purchases;

    public User(PersonBuilder personBuilder) {
        super(personBuilder);
    }
}

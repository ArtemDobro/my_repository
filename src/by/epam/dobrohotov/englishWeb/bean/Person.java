package by.epam.dobrohotov.englishWeb.bean;

import java.util.Objects;

public class Person {
    protected String name;
    protected int age;
    protected String login;
    protected String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && login.equals(person.login) && password.equals(person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, login, password);
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.age = personBuilder.age;
        this.login = personBuilder.login;
        this.password = personBuilder.password;
    }
    public static class PersonBuilder {
        protected String name;
        protected int age;
        protected String login;
        protected String password;
        public PersonBuilder(){
            super();
        }
        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }
        public PersonBuilder age(int age){
            this.age = age;
            return this;
        }
        public PersonBuilder login(String login){
            this.login = login;
            return this;
        }
        public PersonBuilder password(String password){
            this.password = password;
            return this;
        }
        public Person build(){
            Person person = null;
            person = new Person(this);
            return person;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package src.javafx.entities;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String login;
    private String country;
    private String language;

    public int getId() {
        return this.id;
    }

    public User setId(int id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return this.name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getLastName() {
        return this.lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public String getLogin() {
        return this.login;
    }

    public User setLogin(String login) {
        this.login = login;

        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public User setCountry(String country) {
        this.country = country;

        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public User setLanguage(String language) {
        this.language = language;

        return this;
    }
}

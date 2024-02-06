package src.javafx.entities;

public class UserFactory {
    public static User create(int id, String name, String lastName, String login, String country, String language) {
        User user = new User();

        return user
                .setId(id)
                .setName(name)
                .setLastName(lastName)
                .setLogin(login)
                .setCountry(country)
                .setLanguage(language);
    }
}

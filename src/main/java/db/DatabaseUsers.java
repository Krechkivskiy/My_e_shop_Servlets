package db;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUsers {
    private static final List<User> USER_DATABASE = new ArrayList<>();

    public DatabaseUsers() {
        if (USER_DATABASE.isEmpty()) {
            USER_DATABASE.add(new User("admin", "admin"));
            USER_DATABASE.add(new User("user", "user"));
        }
    }

    public void add(User user) {
        USER_DATABASE.add(user);
    }

    public List<User> getAll() {
        return USER_DATABASE;
    }

    public boolean check(User user) {
        return USER_DATABASE.contains(user);
    }
}

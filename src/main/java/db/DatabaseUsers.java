package db;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class DatabaseUsers {
    private static final Map<Integer, User> USER_DATABASE = new HashMap<>();
    private static int counter = 0;

    public DatabaseUsers() {
        if (USER_DATABASE.isEmpty()) {
            USER_DATABASE.put(0, new User(0, "admin", "admin"));
            counter++;
        }
    }

    public void add(User user) {
        user.setId(counter);
        USER_DATABASE.put(counter, user);
        counter++;
    }

    public Map<Integer, User> getAll() {
        return USER_DATABASE;
    }

    public boolean check(User user) {
        return USER_DATABASE.containsValue(user);
    }

    public void change(User user) {
        USER_DATABASE.replace(user.getId(), user);
    }

    public void deleteUser(Integer key) {
        USER_DATABASE.remove(key);
    }
}

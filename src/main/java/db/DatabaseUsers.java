package db;

import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class DatabaseUsers {

    List<User> dbUsers = new ArrayList<>();
    private static int counter = 0;

    public DatabaseUsers() {
        if (dbUsers.isEmpty()) {
            dbUsers.add(new User( "admin", "admin", "admin"));
            counter++;
        }
    }

    public void add(User user) {
        if (!dbUsers.contains(user)) {
            user.setId(counter);
            dbUsers.add(user);
            counter++;
        }
    }

    public List<User> getAll() {
        return dbUsers;
    }

    public Optional<User> checkIsPresentAndGetFullUserData(User user) {
        Iterator<User> iterator = dbUsers.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            if (user.getEmail().equals(next.getEmail()) && user.getPassword()
                    .equals(next.getPassword())) {
                return Optional.ofNullable(next);
            }
        }
        return Optional.empty();
    }

    public void change(int id, User user) {
        dbUsers.set(id, user);
    }

    public void deleteUser(int id) {
        dbUsers.remove(id);
    }
}

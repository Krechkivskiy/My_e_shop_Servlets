package db;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUsers {
    private static final List<User> USER_DATABACE = new ArrayList<>();

    private DatabaseUsers() {
    }

    public static List<User> getDatabase() {
        return USER_DATABACE;
    }
}

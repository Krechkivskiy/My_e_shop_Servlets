package dao.impl;

import dao.UserDao;
import db.DatabaseUsers;
import model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private DatabaseUsers databaseUsers;

    public UserDaoImpl() {
        if (databaseUsers == null) {
            databaseUsers = new DatabaseUsers();
        }
    }

    @Override
    public void addUser(User user) {
        databaseUsers.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return databaseUsers.getAll();
    }

    @Override
    public boolean checkIsPresent(User user) {
        return databaseUsers.check(user);
    }
}

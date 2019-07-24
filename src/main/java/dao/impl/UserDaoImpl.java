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
    public User checkIsPresentAndGetFullUserData(User user) {
        return databaseUsers.checkIsPresentAndGetFullUserData(user);
    }

    @Override
    public void change(int id, User user) {
        databaseUsers.change(id, user);
    }


    @Override
    public void deleteUser(int id) {
        databaseUsers.deleteUser(id);
    }

}

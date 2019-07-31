package dao.impl;

import dao.UserDao;
import db.DatabaseUsers;
import model.User;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> checkIsPresentAndGetFullUserData(User user) {
        return databaseUsers.checkIsPresentAndGetFullUserData(user);
    }

    @Override
    public void change(User user) {

    }

    @Override
    public void change(int id, User user) {
        databaseUsers.change(id, user);
    }


    @Override
    public void deleteUser(int id) {
        databaseUsers.deleteUser(id);
    }

    @Override
    public void deleteUser(User user) {

    }


}

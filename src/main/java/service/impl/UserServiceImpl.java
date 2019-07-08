package service.impl;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        if (userDao == null) {
            userDao = UserDaoFactory.getInstance();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean checkIsPresent(User user) {
        return userDao.checkIsPresent(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}

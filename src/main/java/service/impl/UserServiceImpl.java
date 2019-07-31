package service.impl;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
        if (userDao == null) {
            userDao = UserDaoFactory.getInstance();
        }
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Optional<User> checkIsPresentAndGetFullUserData(User user) {
        return userDao.checkIsPresentAndGetFullUserData(user);
    }

    @Override
    public void change(User user) {
        userDao.change(user);
    }

    @Override
    public void change(int id, User user) {
        userDao.change(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }


}

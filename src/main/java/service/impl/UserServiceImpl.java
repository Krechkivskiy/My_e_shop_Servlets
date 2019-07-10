package service.impl;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.util.Map;


public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
        if (userDao == null) {
            userDao = UserDaoFactory.getInstance();
        }
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean checkIsPresent(User user) {
        return userDao.checkIsPresent(user);
    }

    @Override
    public void change(User user) {
        userDao.change(user);
        LOGGER.debug("user" + user + "changed ");
    }

    @Override
    public void deleteUser(Integer key) {
        User user = userDao.getAllUsers().get(key);
        userDao.deleteUser(key);
        LOGGER.debug("user" + user + "deleted in DB");
    }

    @Override
    public void addUser(User user) {
        user.setId(userDao.getAllUsers().size());
        userDao.addUser(user);
        LOGGER.debug("user" + user + "added in DB");
    }
}

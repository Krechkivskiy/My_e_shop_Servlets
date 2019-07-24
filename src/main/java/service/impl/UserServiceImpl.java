package service.impl;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

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
    public User checkIsPresentAndReturnFullData(User user) {
        return userDao.checkIsPresentAndGetFullUserData(user);
    }

    @Override
    public void edit(int id, User user) {
        userDao.change(id, user);
        LOGGER.debug("user" + user + "changed ");
    }

    @Override
    public void deleteUser(int id) {
        User user = userDao.getAllUsers().get(id);
        userDao.deleteUser(id);
        LOGGER.debug("user" + user + "deleted in Database");
    }


    @Override
    public void addUser(User user) {
        user.setId(userDao.getAllUsers().size());
        userDao.addUser(user);
        LOGGER.debug("user" + user + "added in Database");
    }
}

package dao;

import model.User;

import java.util.Map;

public interface UserDao {

    void addUser(User user);

    Map<Integer, User> getAllUsers();

    boolean checkIsPresent(User user);

    void change(User user);

    void deleteUser(Integer key);
}

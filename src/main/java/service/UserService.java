package service;

import model.User;

import java.util.Map;

public interface UserService {
    void addUser(User user);

    Map<Integer, User> getAllUsers();

    boolean checkIsPresent(User user);

    void edit(User user);

    void deleteUser(Integer key);
}

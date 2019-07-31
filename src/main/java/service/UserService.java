package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    Optional<User> checkIsPresentAndGetFullUserData(User user);

    void change(User user);

    void change(int id, User user);

    void deleteUser(int id);

    void deleteUser(User user);
}

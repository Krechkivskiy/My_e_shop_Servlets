package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    Optional<User> checkIsPresentAndGetFullUserData(User user);

    void change(User user);

    void change(int id, User user);

    void deleteUser(int id);

    void deleteUser(User user);

}

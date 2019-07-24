package dao;

import model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    User checkIsPresentAndGetFullUserData(User user);

    void change(int id, User user);

    void deleteUser(int id);

}

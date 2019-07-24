package service;

import model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User checkIsPresentAndReturnFullData(User user);

    void edit(int id, User user);

    void deleteUser(int id);

}

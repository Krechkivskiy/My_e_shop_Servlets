package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMysqlDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserMysqlDaoImpl.class);
    private Connection connection = MySqlConnection.getConnection();

    public UserMysqlDaoImpl() {
    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users(email,password,role) VALUE('" + user.getEmail()
                + "','" + user.getPassword() + "','" + user.getRole() + "')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                Integer id = Integer.valueOf(resultSet.getString(1));
                String role = resultSet.getString(4);
                userList.add(new User(id, email, password, role));
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to get all user", e);
        }
        return userList;
    }

    @Override
    public User checkIsPresentAndGetFullUserData(User user) {
        User result = null;
        String sql = "SELECT * FROM users WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = new User(resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                result.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to check user", e);
        }
        return result;
    }

    @Override
    public void change(int id, User user) {
        String sql = "UPDATE users SET email=?,password=?,role=? WHERE users.id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to change user", e);
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = " DELETE FROM users WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to delete user", e);
        }
    }
}

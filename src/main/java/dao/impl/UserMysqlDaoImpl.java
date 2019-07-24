package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import util.MySqlConnection;
import util.PasswordHashGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMysqlDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserMysqlDaoImpl.class);
    private static final String ADD_USER_TO_DB = "INSERT INTO users(email,password,role)" +
            " VALUE(?,?,?)";
    private static final String GET_ALL = "SELECT * FROM users LIMIT 1";
    private static final String CHECK_IS_PRESENT_USER = "SELECT * FROM users" +
            " WHERE email=? AND password=?";
    private static final String CHANGE_USER = "UPDATE users SET email=?,password=?,role=? " +
            "WHERE users.id=?";
    private static final String DELETE_USER = " DELETE FROM users WHERE id=?";

    public UserMysqlDaoImpl() {
    }

    @Override
    public void addUser(User user) {
        String hashedPassword = PasswordHashGenerator.getCode(user.getPassword());
        user.setPassword(hashedPassword);
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_TO_DB);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
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
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CHECK_IS_PRESENT_USER);
            String password = PasswordHashGenerator.getCode(user.getPassword());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, password);
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
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_USER);
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
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to delete user", e);
        }
    }
}

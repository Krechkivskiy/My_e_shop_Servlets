package dao.impl;

import dao.CodeDao;
import model.Code;
import model.Order;
import org.apache.log4j.Logger;
import util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeDaoImpl implements CodeDao {

    private static final Logger LOGGER = Logger.getLogger(CodeDaoImpl.class);
    private static final String ADD_CODE = "INSERT INTO code(value,order_id) VALUE (?,?)";
    private static final String GET_CODE_BY_ORDER = "SELECT value FROM code WHERE order_id=? " +
            "ORDER BY id DESC";

    @Override
    public void add(Code code) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_CODE);
            statement.setInt(1, code.getCode());
            statement.setInt(2, code.getOrder().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add code", e);
        }
    }

    @Override
    public int getCode(int orderId) {
        int value = 0;
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CODE_BY_ORDER);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getInt("value");
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to get code", e);
        }
        return value;
    }
}

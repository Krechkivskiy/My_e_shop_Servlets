package dao.impl;

import dao.BasketDao;
import model.User;
import org.apache.log4j.Logger;
import util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketDaoImpl implements BasketDao {

    private static final Logger LOGGER = Logger.getLogger(BasketDaoImpl.class);
    private static final String ADD_PRODUCT = "INSERT INTO product_basket(basket_id,product_id)" +
            " value(?,?)";
    private static final String GET_BASKET_ID_BY_USER = "SELECT id FROM basket" +
            " WHERE user_id =? ORDER BY id DESC";
    private static final String CREATE_BASKET = "INSERT INTO basket(user_id) VALUE(?)";
    private static final String GET_SIZE_OF_BOX = "SELECT COUNT(*) FROM product_basket" +
            " WHERE basket_id = ?";

    @Override
    public void createBasket(User user) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BASKET);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add product", e);
        }
    }

    @Override
    public int getBasketIdByUser(User user) {
        int id = 0;
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BASKET_ID_BY_USER);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add product", e);
        }
        return id;
    }

    @Override
    public void addProduct(User user, int productId) {
        try (Connection connection = MySqlConnection.getConnection()) {
            int basketIdByUser = getBasketIdByUser(user);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setInt(1, basketIdByUser);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to add product", e);
        }
    }

    @Override
    public int getCountOfElements(User user) {
        int result = 0;
        try (Connection connection = MySqlConnection.getConnection()) {
            int basketIdByUser = getBasketIdByUser(user);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SIZE_OF_BOX);
            preparedStatement.setInt(1, basketIdByUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            LOGGER.error("Incorrect try to get count of elements", e);
        }
        return result;
    }
}




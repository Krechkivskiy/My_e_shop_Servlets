package dao.impl;

import dao.OrderDao;
import model.Basket;
import model.Order;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
    private static final String CONFIRM_ORDER = "UPDATE `order` SET confirmed=true " +
            "WHERE user_id =?";
    private static final String GET_ORDER_ID_BY_USER = "SELECT id FROM `order` WHERE user_id =? " +
            "ORDER BY id DESC";
    private static final String GET_PRODUCT_LIST_BY_ORDER =
            "SELECT products.name, products.description, products.price " +
                    "FROM products INNER JOIN product_basket" +
                    "ON products.id= product_basket.product_id " +
                    "INNER JOIN basket ON product_basket.id = basket.id " +
                    "WHERE basket.user_id =? ORDER BY basket.id DESC";
    private static final String CREATE_ORDER = "INSERT " +
            "INTO `order`(name,phone_number,surname,new_post_adress,basket_id,user_id) " +
            "VALUES (?,?,?,?,?,?)";

    @Override
    public void createOrder(Order order) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_ORDER);
            statement.setString(1, order.getName());
            statement.setInt(2, order.getPhoneNumber());
            statement.setString(3, order.getSurname());
            statement.setString(4, order.getNewPostAdress());
            statement.setInt(5, order.getBasket().getId());
            statement.setInt(6, order.getBasket().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to create order", e);
        }
    }

    @Override
    public Order getOrderByUser(User user) {
        return null;
    }

    @Override
    public void confirmOrder(User user) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CONFIRM_ORDER);
            statement.setInt(1, user.getId());
        } catch (SQLException e) {
            LOGGER.error("incorrect try to confirm order");
        }
    }

    @Override
    public int getIdByUser(User user) {
        int id = 0;
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ORDER_ID_BY_USER);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to get id by basket", e);
        }
        return id;
    }

    @Override
    public List<Product> getBasket(User user) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCT_LIST_BY_ORDER);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                productList.add(new Product(resultSet.getString("name"),
                        resultSet.getString("description"), resultSet.getDouble("price")));
            } else return Collections.emptyList();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to get basket", e);
        }
        return productList;
    }
}

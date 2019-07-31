package dao.impl;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductMysqlDbDaoImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(UserMysqlDaoImpl.class);
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM products ";
    private static final String ADD_PRODUCT = "INSERT INTO products(name,description,price) " +
            "VALUE(?,?,?)";
    private static final String EDIT_PRODUCT = "UPDATE products SET name=?,description=?,price=?";
    private static final String DELETE_PRODUCT = "DELETE FROM products where id =?";

    @Override
    public void addProduct(Product product) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            LOGGER.info("incorrect try to add product" + product);
        }
    }

    @Override
    public Optional<Product> getById(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString(1));
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String price = resultSet.getString(4);
                productList.add(new Product(id, name, description, Double.valueOf(price)));
            }
        } catch (SQLException e) {
            LOGGER.error("incorrect try to get all users", e);
        }
        return productList;
    }

    @Override
    public void edit(Product product) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to edit products", e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to delete products", e);
        }
    }
}

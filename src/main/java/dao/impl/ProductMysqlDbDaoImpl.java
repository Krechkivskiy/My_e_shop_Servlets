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

public class ProductMysqlDbDaoImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(UserMysqlDaoImpl.class);
    private Connection connection = MySqlConnection.getConnection();

    @Override
    public void addProduct(Product product) {
        String query = "INSERT INTO products(name,description,price) VALUE('" +
                product.getName() + "','" + product.getDescription() + "','" + product.getPrice() + "')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            LOGGER.info("incorrect try to add product" + product);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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
        String query = "UPDATE products SET name=?,description=?,price='" + product.getPrice() + "'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to edit products", e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products where id =?");) {
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("incorrect try to delete products", e);
        }
    }
}

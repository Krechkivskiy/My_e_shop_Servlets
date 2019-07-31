package dao;

import model.Order;
import model.Product;
import model.User;

import java.util.List;

public interface OrderDao {

    void createOrder(Order order);

    Order getOrderByUser(User user);

    int getIdByUser(User user);

    List<Product> getBasket(User user);

    void confirmOrder(User user);

}

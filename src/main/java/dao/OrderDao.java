package dao;

import model.Basket;
import model.Order;
import model.Product;
import model.User;

import java.util.List;

public interface OrderDao {

    void createOrder(Order order);

    int getIdByBasket(int basketId);

    List<Product> getBasket(User user);

    void confirmOrder(Basket basket);

}

package service;

import model.Order;
import model.Product;
import model.User;

import java.util.List;

public interface OrderService {


    void createOrder(Order order);

    int getIdByBasket(int basketId);

    List<Product> getBasket(User user);

    void confirmOrder(Order order);
}

package service.impl;

import dao.OrderDao;
import factory.OrderDaoFactory;
import model.Basket;
import model.Order;
import model.Product;
import model.User;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final OrderDao orderDao = OrderDaoFactory.getInstance();

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public int getIdByBasket(int basketId) {
        return orderDao.getIdByBasket(basketId);
    }

    @Override
    public List<Product> getBasket(User user) {
        return orderDao.getBasket(user);
    }

    @Override
    public void confirmOrder(Order order) {
        orderDao.confirmOrder(order);
    }
}

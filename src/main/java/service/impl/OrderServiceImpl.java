package service.impl;

import dao.OrderDao;
import factory.OrderDaoFactory;
import model.Order;
import model.Product;
import model.User;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final OrderDao orderDao = OrderDaoFactory.getInstance();

    @Override
    public void createOrder(Order orderId) {
        orderDao.createOrder(orderId);
    }

    @Override
    public Order getOrderUser(User user) {
        return orderDao.getOrderByUser(user);
    }


    @Override
    public List<Product> getBasket(User user) {
        return orderDao.getBasket(user);
    }

    @Override
    public void confirmOrder(User user) {
        orderDao.confirmOrder(user);
    }
}

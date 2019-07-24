package factory;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;

public class OrderDaoFactory {

    private static OrderDao orderDao;

    private OrderDaoFactory() {
    }

    public static OrderDao getInstance() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }
}

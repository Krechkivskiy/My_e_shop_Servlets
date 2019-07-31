package factory;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import dao.impl.hibernate.OrderHiberateDaoImpl;

public class OrderDaoFactory {

    private static OrderDao orderDao;

    private OrderDaoFactory() {
    }

    public static OrderDao getInstance() {
        if (orderDao == null) {
            orderDao = new OrderHiberateDaoImpl();
        }
        return orderDao;
    }
}

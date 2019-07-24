package factory;

import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderServiceFactory {

    private static OrderService orderService;

    private OrderServiceFactory() {
    }

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}

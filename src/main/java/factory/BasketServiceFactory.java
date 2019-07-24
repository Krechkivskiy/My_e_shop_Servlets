package factory;

import service.BasketService;
import service.impl.BasketServiceImpl;

public class BasketServiceFactory  {

    private static BasketService basketService;

    private BasketServiceFactory() {
    }

    public static BasketService getInstance() {
        if (basketService == null) {
            basketService = new BasketServiceImpl();
        }
        return basketService;
    }
}

package factory;

import dao.BasketDao;
import dao.impl.BasketDaoImpl;

public class BasketDaoFactory {

    private static BasketDao basketDao;

    private BasketDaoFactory() {
    }

    public static BasketDao getInstance() {
        if (basketDao == null) {
            basketDao = new BasketDaoImpl();
        }
        return basketDao;
    }
}

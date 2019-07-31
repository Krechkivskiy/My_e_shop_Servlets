package factory;

import dao.BasketDao;
import dao.impl.BasketDaoImpl;
import dao.impl.hibernate.BasketHibernateDaoImpl;

public class BasketDaoFactory {

    private static BasketDao basketDao;

    private BasketDaoFactory() {
    }

    public static BasketDao getInstance() {
        if (basketDao == null) {
            basketDao = new BasketHibernateDaoImpl();
        }
        return basketDao;
    }
}

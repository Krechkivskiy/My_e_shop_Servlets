package factory;

import dao.ProductDAO;
import dao.impl.ProductMysqlDbDaoImpl;
import dao.impl.hibernate.ProductHibernateDaoImpl;

public class ProductDaoFactory {

    private static ProductDAO productDAO;

    private ProductDaoFactory() {
    }

    public static ProductDAO getInstance() {
        if (productDAO == null) {
            productDAO = new ProductHibernateDaoImpl();
        }
        return productDAO;
    }
}

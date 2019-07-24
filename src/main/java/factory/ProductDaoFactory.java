package factory;

import dao.ProductDAO;
import dao.impl.ProductMysqlDbDaoImpl;

public class ProductDaoFactory {

    private static ProductDAO productDAO;

    private ProductDaoFactory() {
    }

    public static ProductDAO getInstance() {
        if (productDAO == null) {
            productDAO = new ProductMysqlDbDaoImpl();
        }
        return productDAO;
    }
}

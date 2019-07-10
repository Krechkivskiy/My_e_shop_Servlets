package factory;

import service.ProductService;
import service.impl.ProductServiceImpl;

public class ProductServiceFactory {
    private static ProductService productService;

    private ProductServiceFactory() {
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }
}

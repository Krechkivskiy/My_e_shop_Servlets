package service.impl;

import dao.ProductDAO;
import factory.ProductDaoFactory;
import model.Product;
import org.apache.log4j.Logger;
import service.ProductService;

import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;
    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {
        if (productDAO == null) {
            productDAO = ProductDaoFactory.getInstance();
        }
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
        LOGGER.debug("Product " + product + " added in DB");
    }

    @Override
    public Map<Integer, Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public void edit(Product product) {
        productDAO.change(product);
        LOGGER.debug("Product " + product + " changed ");
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productDAO.getAll().get(id);
        productDAO.deleteProduct(id);
        LOGGER.debug("Product " + product + " deleted from DB");
    }
}

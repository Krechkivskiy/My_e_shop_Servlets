package service.impl;

import dao.ProductDAO;
import factory.ProductDaoFactory;
import model.Product;
import org.apache.log4j.Logger;
import service.ProductService;

import java.util.List;

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
        LOGGER.debug("Product " + product + " added in Database");
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public void edit(Product product) {
        productDAO.edit(product);
        LOGGER.debug("Product " + product + " changed ");
    }

    @Override
    public void deleteProduct(Integer id) {
        productDAO.deleteProduct(id);
        LOGGER.debug("Product with id  "+id  + " deleted from Database");
    }
}

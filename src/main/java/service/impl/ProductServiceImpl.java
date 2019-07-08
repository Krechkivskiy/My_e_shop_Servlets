package service.impl;

import dao.ProductDAO;
import factory.ProductDaoFactory;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    public ProductServiceImpl() {
        if (productDAO == null) {
            productDAO = ProductDaoFactory.getInstance();
        }
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }
}

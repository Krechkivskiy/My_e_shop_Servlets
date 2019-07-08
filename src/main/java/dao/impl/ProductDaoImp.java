package dao.impl;

import dao.ProductDAO;
import db.ProductsDataBase;
import model.Product;

import java.util.List;

public class ProductDaoImp implements ProductDAO {
    private ProductsDataBase productsDataBase;

    public ProductDaoImp() {
        if (productsDataBase == null) {
            productsDataBase = new ProductsDataBase();
        }
    }

    @Override
    public void addProduct(Product product) {
        productsDataBase.addProduct(product);
    }

    @Override
    public List<Product> getAll() {
        return productsDataBase.getProductDB();
    }
}

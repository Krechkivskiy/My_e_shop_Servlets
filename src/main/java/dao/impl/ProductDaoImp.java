package dao.impl;

import dao.ProductDAO;
import db.ProductsDataBase;
import model.Product;

import java.util.Map;

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
    public Map<Integer, Product> getAll() {
        return productsDataBase.getProductDB();
    }

    @Override
    public void change(Product product) {
        productsDataBase.change(product);
    }

    @Override
    public void deleteProduct(Integer key) {
        productsDataBase.deleteProduct(key);
    }
}

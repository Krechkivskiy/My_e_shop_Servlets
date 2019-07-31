package dao.impl;

import dao.ProductDAO;
import db.ProductsDataBase;
import model.Product;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return productsDataBase.getProductDatabase();
    }

    @Override
    public void edit(Product product) {
        productsDataBase.edit(product);
    }

    @Override
    public void deleteProduct(int id) {
        productsDataBase.deleteProduct(id);
    }
}

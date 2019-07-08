package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);

    List<Product> getAll();
}

package dao;

import model.Product;

import java.util.Map;

public interface ProductDAO {
    void addProduct(Product product);

    Map<Integer, Product> getAll();

    void change(Product product);

    void deleteProduct(Integer id);
}

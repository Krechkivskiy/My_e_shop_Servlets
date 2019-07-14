package dao;

import model.Product;

import java.util.Map;

public interface ProductDAO {
    void addProduct(Product product);

    Map<Integer, Product> getAll();

    void edit(Product product);

    void deleteProduct(int id);
}

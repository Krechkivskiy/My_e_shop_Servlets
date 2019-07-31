package dao;

import model.Product;
import model.User;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    void addProduct(Product product);

    Optional<Product> getById(int id);

    List<Product> getAll();

    void edit(Product product);

    void deleteProduct(int id);
}

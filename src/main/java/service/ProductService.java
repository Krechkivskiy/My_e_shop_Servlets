package service;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAll();

    void edit(Product product);

    Optional<Product> getById(int id);

    void deleteProduct(Integer id);
}

package db;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDataBase {

    private List<Product> productDatabase = new ArrayList<>();
    private static int id = 0;

    public ProductsDataBase() {
    }

    public void addProduct(Product product) {
        if (!productDatabase.contains(product)) {
            product.setId(id);
            productDatabase.add(product);
            id++;
        }
    }

    public List<Product> getProductDatabase() {
        return productDatabase;
    }

    public void edit(Product product) {
        productDatabase.set(product.getId(), product);
    }

    public void deleteProduct(int id) {
        productDatabase.remove(id);
    }


}

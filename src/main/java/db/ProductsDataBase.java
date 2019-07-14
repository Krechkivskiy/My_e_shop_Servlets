package db;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductsDataBase {
    private HashMap<Integer, Product> productDatabase = new HashMap<>();
    private static int id = 0;

    public ProductsDataBase() {
    }

    public void addProduct(Product product) {
        product.setId(id);
        productDatabase.put(id, product);
        id++;
    }

    public Map<Integer, Product> getProductDB() {
        return productDatabase;
    }

    public void edit(Product product) {
        productDatabase.replace(product.getId(), product);
    }

    public void deleteProduct(Integer key) {
        productDatabase.remove(key);
    }


}

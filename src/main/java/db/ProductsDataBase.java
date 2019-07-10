package db;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductsDataBase {
    private static final HashMap<Integer, Product> PRODUCT_DATABASE = new HashMap<>();
    private static Integer id = 0;

    public ProductsDataBase() {
    }

    public void addProduct(Product product) {
        product.setId(id);
        PRODUCT_DATABASE.put(product.getId(), product);
        id++;
    }

    public Map<Integer, Product> getProductDB() {
        return PRODUCT_DATABASE;
    }

    public void change(Product product) {
        PRODUCT_DATABASE.replace(product.getId(), product);
    }

    public void deleteProduct(Integer key) {
        PRODUCT_DATABASE.remove(key);
    }
}

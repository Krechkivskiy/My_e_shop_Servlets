package db;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDataBase {
    private static final ArrayList<Product> PRODUCT_LIST = new ArrayList<>();

    public ProductsDataBase() {
    }

    public void addProduct(Product product) {
        PRODUCT_LIST.add(product);
    }

    public List<Product> getProductDB() {
        return PRODUCT_LIST;
    }
}

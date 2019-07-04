package db;

import model.Product;

import java.util.ArrayList;

public class ProductsDataBase {
    private static final ArrayList<Product> PRODUCT_LIST = new ArrayList<>();

    private ProductsDataBase() {
    }

    public static ArrayList<Product> getProductDB() {
        return PRODUCT_LIST;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Product> productList = new ArrayList<>();

    public Box() {
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void clear() {
        productList.clear();
    }

    public List<Product> getAll() {
        return productList;
    }

    public int size() {
        return productList.size();
    }
}

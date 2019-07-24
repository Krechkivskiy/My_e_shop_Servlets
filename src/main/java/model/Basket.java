package model;

import java.util.List;

public class Basket {

    private int id;
    private User user;
    private List<Product> productList;


    public Basket(int id, User user, List<Product> productList) {
        this.id = id;
        this.user = user;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }


    public User getUser() {
        return user;

    }
}

package model;

public class Basket {

    private int id;
    private User user;
    private Product product;

    public Basket(int id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }


    public User getUser() {
        return user;

    }
}

package service;

import model.Basket;
import model.Product;
import model.User;

public interface BasketService {

    void addProduct(User user,int id);

    void addProduct(User user, Product product);

    void addProductByBasket(Basket basket);

    long getCountOfElements(User user);

    void createBasket(User user);

    void  createBasket(Basket basket);

    int getBasketIdByUser(User user);

}

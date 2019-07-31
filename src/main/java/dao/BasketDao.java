package dao;

import model.Basket;
import model.Product;
import model.User;

import java.util.Optional;

public interface BasketDao {

    void addProduct(User user, int id);

    void addProduct(User user, Product product);

    Optional<Basket> getBasketByUser(User user);

    long getCountOfElements(User user);

    void createBasket(User user);

    void createBasket(Basket basket);

    int getBasketIdByUser(User user);
}

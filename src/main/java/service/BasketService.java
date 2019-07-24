package service;

import model.User;

public interface BasketService {

    void addProduct(User user, int id);

    int getCountOfElements(User user);

    void createBasket(User user);

    int getBasketIdByUser(User user);
}

package service.impl;

import dao.BasketDao;
import factory.BasketDaoFactory;
import model.Basket;
import model.Product;
import model.User;
import service.BasketService;

public class BasketServiceImpl implements BasketService {

    private BasketDao basketDao = BasketDaoFactory.getInstance();

    @Override
    public void addProductByBasket(Basket basket) {}

    @Override
    public void addProduct(User user, int id) {
        basketDao.addProduct(user, id);
    }

    @Override
    public void addProduct(User user, Product product) {
        basketDao.addProduct(user, product);
    }

    @Override
    public long getCountOfElements(User user) {
        return basketDao.getCountOfElements(user);
    }

    @Override
    public void createBasket(User user) {
        basketDao.createBasket(user);
    }

    @Override
    public void createBasket(Basket basket) {
        basketDao.createBasket(basket);
    }

    @Override
    public int getBasketIdByUser(User user) {
        return basketDao.getBasketIdByUser(user);
    }
}

package service.impl;

import dao.BasketDao;
import factory.BasketDaoFactory;
import model.User;
import service.BasketService;

public class BasketServiceImpl implements BasketService {

    private BasketDao basketDao = BasketDaoFactory.getInstance();

    @Override
    public void addProduct(User user, int id) {
        basketDao.addProduct(user, id);
    }

    @Override
    public int getCountOfElements(User user) {
        return basketDao.getCountOfElements(user);
    }

    @Override
    public void createBasket(User user) {
        basketDao.createBasket(user);
    }

    @Override
    public int getBasketIdByUser(User user) {
       return basketDao.getBasketIdByUser(user);
    }
}

package dao.impl.hibernate;

import dao.BasketDao;
import model.Basket;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateConfiguration;

import java.util.List;
import java.util.Optional;

public class BasketHibernateDaoImpl implements BasketDao {

    private static final Logger LOGGER = Logger.getLogger(BasketHibernateDaoImpl.class);

    @Override
    public void addProduct(User user, int id) {
    }

    @Override
    public void addProduct(User user, Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (getBasketByUser(user).isPresent()){
            Basket basketByUser = getBasketByUser(user).get();
                List<Product> productList = basketByUser.getProductList();
                productList.add(product);
                basketByUser.setProductList(productList);
                session.update(basketByUser);
                transaction.commit();
            }
        } catch (Exception e) {
            LOGGER.error("incorrect try to add product", e);
        }
    }

    @Override
    public Optional<Basket> getBasketByUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Basket WHERE user.email=:id");
            query.setString("id", user.getEmail());
            Basket basket = (Basket) query.uniqueResult();
            transaction.commit();
            return Optional.ofNullable(basket);
        } catch (Exception e) {
            LOGGER.error("incorrect try to get basket by user", e);
        }
        return Optional.empty();
    }

    @Override
    public long getCountOfElements(User user) {
        Transaction transaction = null;
        long result = 0;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (getBasketByUser(user).isPresent()) {
                Basket basketByUser = getBasketByUser(user).get();
                result = basketByUser.getProductList().size();
            }
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to get count of elements", e);
        }
        return result;
    }

    @Override
    public void createBasket(User user) {
    }

    @Override
    public void createBasket(Basket basket) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(basket);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to create basket", e);
        }
    }

    @Override
    public int getBasketIdByUser(User user) {
        return 0;
    }
}

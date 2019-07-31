package dao.impl.hibernate;

import dao.OrderDao;
import model.Order;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateConfiguration;

import java.util.List;

public class OrderHiberateDaoImpl implements OrderDao {

    private static final Logger LOGGER = Logger.getLogger(UserHibernateDao.class);

    @Override
    public void createOrder(Order order) {
        Transaction transaction;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to create order", e);
        }
    }

    @Override
    public Order getOrderByUser(User user) {
        Order result = null;
        Transaction transaction;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Order> GET_ORDER_BY_USER = session.createQuery("from Order WHERE user.id=:id", Order.class);
            GET_ORDER_BY_USER.setInteger("id", user.getId());
            List<Order> list = GET_ORDER_BY_USER.list();
            result = list.get(list.size() - 1);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to get order by user", e);
        }
        return result;
    }

    @Override
    public int getIdByUser(User user) {
        return 0;
    }

    @Override
    public List<Product> getBasket(User user) {
        return null;
    }

    @Override
    public void confirmOrder(User user) {
        Order order = getOrderByUser(user);
        Transaction transaction = null;
        order.setConfirmed(true);
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to confirm order", e);
        }
    }
}

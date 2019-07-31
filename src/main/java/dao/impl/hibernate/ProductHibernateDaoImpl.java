package dao.impl.hibernate;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateConfiguration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductHibernateDaoImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(UserHibernateDao.class);

    @Override
    public void addProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to add product", e);
        }
    }

    @Override
    public List<Product> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query from_product_ = session.createQuery("FROM Product ");
            List list = from_product_.list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            LOGGER.error("incorrect try to get all products", e);
        }
        return Collections.emptyList();
    }

    @Override
    public void edit(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to edit product user", e);
        }
    }

    @Override
    public Optional<Product> getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Product user = session.find(Product.class, id);
            transaction.commit();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            LOGGER.error("incorrect try to get product by id", e);
        }
        return Optional.empty();
    }

    @Override
    public void deleteProduct(int id) {
        if (getById(id).isPresent()) {
            Product byId = getById(id).get();
            Transaction transaction = null;
            try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.remove(byId);
                transaction.commit();
            } catch (Exception e) {
                LOGGER.error("incorrect try to delete product", e);
            }
        }
    }
}

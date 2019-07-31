package dao.impl.hibernate;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateConfiguration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserHibernateDao implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserHibernateDao.class);

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to add user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<User> allUsers = session.createQuery("from User ", User.class).list();
            transaction.commit();
            return allUsers;
        } catch (Exception e) {
            LOGGER.error("incorrect try to get user", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<User> checkIsPresentAndGetFullUserData(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User where email =:email and password =:password", User.class);
            query.setString("email", user.getEmail());
            query.setString("password", user.getPassword());
            User user1 = query.uniqueResult();
            transaction.commit();
            return Optional.ofNullable(user1);
        } catch (Exception e) {
            LOGGER.error("incorrect try to get user", e);
        }
        return Optional.empty();
    }

    @Override
    public void change(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to get user", e);
        }
    }

    @Override
    public void change(int id, User user) {
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> userById = getUserById(id);
        if (userById.isPresent()) {
            deleteUser(userById.get());
        }
    }

    @Override
    public void deleteUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to get user", e);
        }
    }

    private Optional<User> getUserById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            transaction.commit();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            LOGGER.error("incorrect try to get user", e);
        }
        return Optional.empty();

    }
}

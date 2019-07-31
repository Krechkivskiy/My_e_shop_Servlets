package dao.impl.hibernate;

import dao.CodeDao;
import model.Code;
import model.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateConfiguration;

public class CodeHibernateDao implements CodeDao {

    private static final Logger LOGGER = Logger.getLogger(CodeHibernateDao.class);

    @Override
    public void add(Code code) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(code);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("incorrect try to create code", e);
        }
    }

    @Override
    public int getCode(int orderId) {
        return 0;
    }

    @Override
    public int getCode(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Code> query = session.createQuery("FROM Code WHERE order.id=:id", Code.class);
            Code result = query.setInteger("id", order.getId()).uniqueResult();
            transaction.commit();
            return result.getCode();
        } catch (Exception e) {
            LOGGER.error("incorrect try to get code", e);
        }
        return 0;
    }
}

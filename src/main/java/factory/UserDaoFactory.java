package factory;

import dao.UserDao;
import dao.impl.UserMysqlDaoImpl;
import dao.impl.hibernate.UserHibernateDao;

public class UserDaoFactory {

    private static UserDao instance;

    private UserDaoFactory() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserHibernateDao();
        }
        return instance;
    }
}

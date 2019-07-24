package factory;

import dao.UserDao;
import dao.impl.UserMysqlDaoImpl;

public class UserDaoFactory {

    private static UserDao instance;

    private UserDaoFactory() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserMysqlDaoImpl();
        }
        return instance;
    }
}

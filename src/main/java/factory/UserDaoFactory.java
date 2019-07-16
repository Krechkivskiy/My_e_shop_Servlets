package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoFactory {

    private static UserDaoImpl instance;

    private UserDaoFactory() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
}

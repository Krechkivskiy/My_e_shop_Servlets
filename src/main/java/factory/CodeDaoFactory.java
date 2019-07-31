package factory;

import dao.CodeDao;
import dao.impl.CodeDaoImpl;
import dao.impl.hibernate.CodeHibernateDao;

public class CodeDaoFactory {

    private static CodeDao codeDao;

    private CodeDaoFactory() {
    }

    public static CodeDao getInstance() {
        if (codeDao == null) {
            codeDao = new CodeHibernateDao();
        }
        return codeDao;
    }
}

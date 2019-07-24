package factory;

import dao.CodeDao;
import dao.impl.CodeDaoImpl;

public class CodeDaoFactory {

    private static CodeDao codeDao;

    private CodeDaoFactory() {
    }

    public static CodeDao getInstance() {
        if (codeDao == null) {
            codeDao = new CodeDaoImpl();
        }
        return codeDao;
    }
}

package factory;

import service.CodeService;
import service.impl.CodeServiceImpl;

public class CodeServiceFactory {

    private static CodeService codeService;

    private CodeServiceFactory() {
    }

    public static CodeService getInstance() {
        if (codeService == null) {
            codeService = new CodeServiceImpl();
        }
        return codeService;
    }
}

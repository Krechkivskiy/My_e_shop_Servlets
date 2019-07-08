package factory;

import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceFactory {
    private static UserService userService;

    private UserServiceFactory() {
    }

    public static UserService getInnstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}

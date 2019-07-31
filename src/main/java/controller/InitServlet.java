package controller;

import factory.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {

    public InitServlet() {
    }

    @Override
    public void init() throws ServletException {
        UserService userService = UserServiceFactory.getInnstance();
        userService.addUser(new User("admin", "12345", "admin"));
        userService.addUser(new User("user", "user", "user"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

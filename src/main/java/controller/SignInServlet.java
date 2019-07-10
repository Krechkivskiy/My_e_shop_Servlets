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
import java.util.Map;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceFactory.getInnstance();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("email"),
                request.getParameter("password"));
        Map<Integer, User> allUsers = USER_SERVICE.getAllUsers();
        boolean checkIsPresent = USER_SERVICE.checkIsPresent(user);
        if (checkIsPresent) {
            request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}

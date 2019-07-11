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

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceFactory.getInnstance();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("rpassword");
        if (password.equals(repeatedPassword)) {
            USER_SERVICE.addUser(new User(email, password));
            request.setAttribute("userDB", USER_SERVICE.getAllUsers());
            request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Save.jsp").forward(request, response);
        }
    }
}

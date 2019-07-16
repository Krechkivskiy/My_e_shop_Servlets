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

@WebServlet("/admin/register")
public class RegisterUserServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInnstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("rpassword");
        String role = request.getParameter("role");
        User user = new User(email, password, role);
        if (password.equals(repeatedPassword)) {
            userService.addUser(user);
            request.setAttribute("userDatabase", userService.getAllUsers());
            request.getRequestDispatcher("/page_to_save.jsp").forward(request, response);
        } else {
            request.setAttribute("email", email);
            request.setAttribute("errorMessage", "please enter the same password");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }
}

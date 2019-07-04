package controller;

import db.DatabaseUsers;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("rpassword");
        List<User> database = DatabaseUsers.getDatabase();
        if (password.equals(repeatedPassword)) {
            database.add(new User(email, password));
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else {
            request.setAttribute("set", email);
            request.setAttribute("value", "misha");
            request.getRequestDispatcher("Sign_in.jsp").forward(request, response);
        }
    }
}

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String email1 = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatedpassword = request.getParameter("rpassword");
        List<User> database = DatabaseUsers.getDatabase();
        if (password.equals(repeatedpassword)) {
            database.add(new User(email1, password));
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

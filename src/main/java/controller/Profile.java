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
import java.util.List;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        UserService service = UserServiceFactory.getInnstance();
        User user = new User(request.getParameter("email"),
                request.getParameter("password"));
        List<User> allUsers = service.getAllUsers();
        boolean checkIsPresent = service.checkIsPresent(user);
        if (checkIsPresent) {
            request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}

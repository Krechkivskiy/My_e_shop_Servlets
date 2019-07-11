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

@WebServlet("/changeUser")
public class ChangeUserServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceFactory.getInnstance();
    private int[] idToChange = new int[1];

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        idToChange[0] = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("userDB",USER_SERVICE.getAllUsers());
        request.getRequestDispatcher("Page_to_change_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(idToChange[0], email, password);
        USER_SERVICE.edit(user);
        request.setAttribute("userDB",USER_SERVICE.getAllUsers());
        request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
    }
}

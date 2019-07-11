package controller;

import factory.UserServiceFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceFactory.getInnstance();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        USER_SERVICE.deleteUser(Integer.valueOf(id));
        request.setAttribute("userDB", USER_SERVICE.getAllUsers());
        request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
    }
}

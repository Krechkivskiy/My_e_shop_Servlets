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
import java.util.Optional;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private static UserService userService = UserServiceFactory.getInnstance();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        Optional<User> user = (Optional<User>) request.getSession().getAttribute("user");
        if (user.isPresent() && user.get().getRole().equals("admin")) {
            request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Error_Page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        User inputUser = new User(request.getParameter("email"),
                request.getParameter("password"));
        Optional<User> user = Optional.ofNullable(userService.checkIsPresentAndReturnFullData(inputUser));
        if (user.isPresent()) {
            if (user.get().getRole().equals("admin")) {
                request.getSession().setAttribute("user", user.get());
                request.getRequestDispatcher("Page_to_save.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("user", user.get());
                request.getRequestDispatcher("product.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "incorrect data please try again");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

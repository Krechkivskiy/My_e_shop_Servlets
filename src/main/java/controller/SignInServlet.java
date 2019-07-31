package controller;

import factory.BasketServiceFactory;
import factory.ProductServiceFactory;
import factory.UserServiceFactory;
import model.Basket;
import model.User;
import service.BasketService;
import service.ProductService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = UserServiceFactory.getInnstance();
        User inputUser = new User(request.getParameter("email"),
                request.getParameter("password"));
        Optional<User> user = userService.checkIsPresentAndGetFullUserData(inputUser);
        if (user.isPresent()) {
            User userNotNull = user.get();
            userService.checkIsPresentAndGetFullUserData(userNotNull);
            if (userNotNull.getRole().equals("admin")) {
                request.getSession().setAttribute("user", userNotNull);
                request.setAttribute("userDatabase", userService.getAllUsers());
                request.getRequestDispatcher("/page_to_save.jsp").forward(request, response);
            } else {
                request.setAttribute("productDatabase", productService.getAll());
                BasketService basketService = BasketServiceFactory.getInstance();
                if (userNotNull.getBasket() == null) {
                    basketService.createBasket(userNotNull);
                    Basket basket = new Basket(userNotNull, Collections.emptyList());
                    userNotNull.setBasket(basket);
                    userService.change(userNotNull);
                }
                request.getSession().setAttribute("user", userNotNull);
                request.setAttribute("box", basketService
                        .getCountOfElements(userNotNull) + " elements");
                request.getRequestDispatcher("/buy_product.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "incorrect data please try again");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}

package controller;

import factory.BasketServiceFactory;
import factory.ProductServiceFactory;
import model.Product;
import model.User;
import service.BasketService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToBox")
public class AddProductInBoxServlet extends HttpServlet {

    private static final BasketService basketService = BasketServiceFactory.getInstance();
    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.valueOf(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        if (user.getBasket() == null) {
            basketService.createBasket(user);
        }
        if (productService.getById(productId).isPresent()) {
            Product product = productService.getById(productId).get();
            basketService.addProduct(user, product);
            request.getSession().setAttribute("user", user);
            request.setAttribute("productDatabase", productService.getAll());
            request.setAttribute("box", basketService.getCountOfElements(user));
            request.getRequestDispatcher("/buy_product.jsp").forward(request, response);
        }
    }
}


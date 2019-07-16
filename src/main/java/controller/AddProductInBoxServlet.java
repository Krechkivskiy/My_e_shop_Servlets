package controller;

import factory.ProductServiceFactory;
import model.Product;
import model.User;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToBox")
public class AddProductInBoxServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer productId = Integer.valueOf(request.getParameter("product.id"));
        Product product = productService.getAll().get(productId);
        User user = (User) request.getSession().getAttribute("user");
        user.addProduct(product);
        request.getSession().setAttribute("user", user);
        request.setAttribute("productDatabase", productService.getAll());
        request.setAttribute("box", "BOX - " + user.getBoxSize() + " elements");
        request.getRequestDispatcher("/buy_product.jsp").forward(request, response);
    }
}


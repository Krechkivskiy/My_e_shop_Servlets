package controller;

import factory.ProductServiceFactory;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer productId = Integer.valueOf(id);
        PRODUCT_SERVICE.deleteProduct(productId);
        request.setAttribute("productDB", PRODUCT_SERVICE.getAll());
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}

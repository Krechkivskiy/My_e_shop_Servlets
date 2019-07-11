package controller;

import factory.ProductServiceFactory;
import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeProduct")
public class ChangeProductServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = ProductServiceFactory.getInstance();
    private static Integer id;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer productId = Integer.valueOf(id);
        ChangeProductServlet.id = productId;
        request.setAttribute("productDB", PRODUCT_SERVICE.getAll());
        request.getRequestDispatcher("Page_to_change_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        String name = request.getParameter("name");
        product.setName(name);
        String description = request.getParameter("description");
        product.setDescription(description);
        String price = request.getParameter("price");
        product.setId(id);
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);
        } catch (NumberFormatException nfe) {
            product.setPrice(0.0);
        }
        PRODUCT_SERVICE.edit(product);
        request.setAttribute("productDB", PRODUCT_SERVICE.getAll());
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}

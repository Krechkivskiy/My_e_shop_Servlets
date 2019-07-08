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

@WebServlet("/productSave")
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        ProductService service = ProductServiceFactory.getIstance();
        Product product = new Product();
        String name = request.getParameter("name");
        product.setName(name);
        String description = request.getParameter("description");
        product.setDescriptional(description);
        String price = request.getParameter("price");
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);

        } catch (NumberFormatException nfe) {
            product.setPrice(0.0);
        }
        service.addProduct(product);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

}

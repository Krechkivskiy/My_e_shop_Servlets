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

@WebServlet("/admin/productSave")
public class SaveProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("productDatabase", productService.getAll());
        request.getRequestDispatcher("/product.jsp").forward(request, response);
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
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);
        } catch (NumberFormatException nfe) {
            request.setAttribute("priceError","incorrect price ");
            request.setAttribute("productDatabase",productService.getAll());
            request.getRequestDispatcher("/product.jsp").forward(request,response);
        }
        productService.addProduct(product);
        request.setAttribute("productDatabase", productService.getAll());
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }
}

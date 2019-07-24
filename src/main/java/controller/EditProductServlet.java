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

@WebServlet("/admin/editProduct")
public class EditProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("/page_to_change_product.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        Product product = new Product(name, description, 0.0);
        product.setId(id);
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);
        } catch (NumberFormatException nfe) {
            request.setAttribute("priceError","Incorrect price  please try again");
            request.getRequestDispatcher("/product.jsp").forward(request,response);
        }
        productService.edit(product);
        request.setAttribute("productDatabase", productService.getAll());
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }
}

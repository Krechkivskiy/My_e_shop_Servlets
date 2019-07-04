package controller;

import db.ProductsDataBase;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> productDB = ProductsDataBase.getProductDB();
        Product product = new Product();
        String name = request.getParameter("name");
        product.setName(name);
        String descriptional = request.getParameter("descriptional");
        product.setDescriptional(descriptional);
        String price = request.getParameter("price");
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);

        } catch (NumberFormatException nfe) {
            product.setPrice(0.0);
        }
        productDB.forEach(myProduct -> System.out.println(product));
    }
}

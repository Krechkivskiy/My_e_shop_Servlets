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
        if (name.equals(null)) {
            product.setName(name);
        } else {
            product.setName("undefined");
        }
        String descriptional = request.getParameter("descriptional");
        if (descriptional.equals(null)) {
            product.setDescriptional(descriptional);
        } else {
            product.setDescriptional("undefined");
        }
        String price = request.getParameter("price");

        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);

        } catch (NumberFormatException nfe) {
            product.setPrice(0.0);
        }
        productDB.forEach(product1 -> System.out.println(product));
    }
}

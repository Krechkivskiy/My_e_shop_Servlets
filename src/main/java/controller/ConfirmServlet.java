package controller;

import factory.CodeServiceFactory;
import factory.OrderServiceFactory;
import model.Code;
import model.Order;
import model.User;
import service.CodeService;
import service.MailService;
import service.OrderService;
import service.impl.MailServiceImpl;
import util.Generator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderService orderService = OrderServiceFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        Order order = new Order(request.getParameter("name"),
                request.getParameter("surname"), request.getParameter("newPostAdress"),
                Integer.valueOf(request.getParameter("phone")), user.getBoxId());
        orderService.createOrder(order);
        int idBasket = orderService.getIdByBasket(user.getBoxId());
        order.setId(idBasket);
        Code code = new Code(Generator.getVerificationCode(), order);
        CodeService codeService = CodeServiceFactory.getInstance();
        codeService.add(code);
        String email = user.getEmail();
        MailService mailService = new MailServiceImpl();
        mailService.send(email, String.valueOf(code.getCode()));
        request.getRequestDispatcher("/confirm_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inputCode = request.getParameter("code");
        Order order1 = (Order) request.getSession().getAttribute("order");
        int code = CodeServiceFactory.getInstance().getCode(order1);
        if (inputCode.equals(String.valueOf(code))) {
            OrderService orderService = OrderServiceFactory.getInstance();
            //TODO допилить подтверждение через корзину
            orderService.confirmOrder();
            request.setAttribute("resultOrder", "Succes");
            request.getRequestDispatcher("buy_product.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMsg", "incorrect code please try again");
            request.getRequestDispatcher("confirm_password.jsp").forward(request, response);
        }
    }
}

package controller;

import model.User;
import service.MailService;
import service.impl.MailServiceImpl;
import util.Verificator;

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

        User user = (User) request.getSession().getAttribute("user");
        String email = user.getEmail();
        MailService sendler = new MailServiceImpl();
        String code = String.valueOf(Verificator.getVerificationCode());
        user.setVerificationCode(code);
        sendler.send(email, code);
        request.getRequestDispatcher("/confirm_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inputCode = request.getParameter("code");
        User user = (User) request.getSession().getAttribute("user");
        String verificationCode = user.getVerificationCode();
        if (inputCode.equals(verificationCode)) {
            user.setVerificationCode(null);
            user.clear();
            request.setAttribute("resultOrder", "Succes");
            request.getRequestDispatcher("buy_product.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMsg", "incorrect code please try again");
            request.getRequestDispatcher("confirm_password.jsp").forward(request, response);
        }
    }
}

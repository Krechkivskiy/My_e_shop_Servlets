package controller.filrters;

import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class DbSetFilter implements Filter {
    UserServiceImpl userService = new UserServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("userDB", userService.getAllUsers());
        req.setAttribute("productDB", productService.getAll());
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }
}

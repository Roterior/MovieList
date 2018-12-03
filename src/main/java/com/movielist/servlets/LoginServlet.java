package com.movielist.servlets;

import com.movielist.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("This is a login page!");
            String login = req.getParameter("login");
            String pass = req.getParameter("password");
            //Example: http://localhost:8081/user/login?login=admin&password=123
            if (userService.loginUser(login,pass).getLogin() != null) {
                out.println("Welcome, " + userService.loginUser(login,pass).getfName());
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
            }
            else {
                out.println("Access denied!");
            }
        }
        catch (Exception e ) { e.printStackTrace(); }
    }
}

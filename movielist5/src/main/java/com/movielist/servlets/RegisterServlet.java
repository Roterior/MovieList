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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", urlPatterns = "/user/register")
public class RegisterServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("This is a register page!");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            //Example: localhost:8081/user/register?login=joinme&password=ez4me&name=Max
            if (userService.registerUser(login,password,name).getLogin() != null) {
                out.println("<br>New user has been registered!");
            }
            else {
                out.println("<br>Error!");
            }
        }
        catch (Exception e ) { e.printStackTrace(); }
    }
}

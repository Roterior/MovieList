package com.movielist.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/user/login")
public class LoginFilter implements Filter {

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpSession session = httpReq.getSession(false);
        String path = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
        if (path.equals("/user/login")) {
            if (session != null) {
                String name = (String)session.getAttribute("login");
                if (name != null) {
                    throw new ServletException("Logout first! Then you will be able to login.");
                }
            }
            else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {}
}

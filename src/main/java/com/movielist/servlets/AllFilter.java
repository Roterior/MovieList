package com.movielist.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*")
public class AllFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);
        String path = req.getRequestURI().substring(req.getContextPath().length());
        if (path.equals("/user/login") || path.equals("/user/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            if (session != null) {
                String name = (String)session.getAttribute("login");
                if (name != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
            else {
                throw new ServletException("You shall not pass!");
            }
        }
    }

    @Override
    public void destroy() {}
}

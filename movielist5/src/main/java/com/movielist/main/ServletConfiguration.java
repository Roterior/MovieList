package com.movielist.main;

import com.movielist.servlets.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean loginServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new LoginServlet(), "/user/login");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new RegisterServlet(), "/user/register");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean logoutServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new LogoutServlet(), "/user/logout");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean servletFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AllFilter());
        bean.addUrlPatterns("*");
        return bean;
    }

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new LoginFilter());
        bean.addUrlPatterns("/user/login");
        return bean;
    }
}
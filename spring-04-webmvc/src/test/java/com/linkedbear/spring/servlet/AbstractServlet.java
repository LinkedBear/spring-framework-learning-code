package com.linkedbear.spring.servlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory()
                .autowireBean(this);
    }
}

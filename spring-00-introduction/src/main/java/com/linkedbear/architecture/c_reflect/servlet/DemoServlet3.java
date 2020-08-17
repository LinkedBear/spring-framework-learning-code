package com.linkedbear.architecture.c_reflect.servlet;

import com.linkedbear.architecture.c_reflect.factory.BeanFactory;
import com.linkedbear.architecture.c_reflect.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo3")
public class DemoServlet3 extends HttpServlet {
    
    DemoService demoService = BeanFactory.getDemoService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

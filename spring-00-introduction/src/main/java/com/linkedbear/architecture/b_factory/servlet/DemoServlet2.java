package com.linkedbear.architecture.b_factory.servlet;

import com.linkedbear.architecture.b_factory.factory.BeanFactory;
import com.linkedbear.architecture.b_factory.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class DemoServlet2 extends HttpServlet {
    
    DemoService demoService = BeanFactory.getDemoService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}

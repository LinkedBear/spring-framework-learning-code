package com.linkedbear.architecture.h_decorator.servlet;

import com.linkedbear.architecture.h_decorator.factory.BeanFactory;
import com.linkedbear.architecture.h_decorator.service.DemoService;
import com.linkedbear.architecture.h_decorator.service.decorator.DemoServiceDecorator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo8")
public class DemoServlet8 extends HttpServlet {
    
    DemoService demoService = new DemoServiceDecorator((DemoService) BeanFactory.getBean("demoService"));
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("bearbear", 666);
        demoService.subtract("bearbear", 666);
    }
}

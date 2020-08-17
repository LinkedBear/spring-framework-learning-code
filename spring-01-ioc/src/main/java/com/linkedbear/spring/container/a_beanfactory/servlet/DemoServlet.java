package com.linkedbear.spring.container.a_beanfactory.servlet;

import com.linkedbear.spring.container.a_beanfactory.bean.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    
    @Autowired
    private Cat cat;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 借助ServletContext获取到IOC容器
        ServletContext servletContext = config.getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        
        // 使用依赖查找的形式查找Cat
        this.cat = ctx.getBean(Cat.class);
        
        // 使用依赖注入的形式注入Cat
        ctx.getAutowireCapableBeanFactory().autowireBean(this);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DemoServlet doGet run ......" + cat);
    }
}

package com.linkedbear.architecture.j_proxy.servlet;

import com.linkedbear.architecture.j_proxy.factory.BeanFactory;
import com.linkedbear.architecture.j_proxy.service.DemoService;
import com.linkedbear.architecture.j_proxy.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;

@WebServlet(urlPatterns = "/demo10")
public class DemoServlet10 extends HttpServlet {
    
    DemoService demoService;
    
    @Override
    public void init() throws ServletException {
        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        Class<? extends DemoService> clazz = demoService.getClass();
        this.demoService = (DemoService) Proxy
                .newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
                    LogUtils.printLog("DemoService", method.getName(), args);
                    return method.invoke(demoService, args);
                });
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("bearbear", 666);
        demoService.subtract("bearbear", 666);
    }
}

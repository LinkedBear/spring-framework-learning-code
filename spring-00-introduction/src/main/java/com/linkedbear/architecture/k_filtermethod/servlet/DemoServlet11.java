package com.linkedbear.architecture.k_filtermethod.servlet;

import com.linkedbear.architecture.k_filtermethod.factory.BeanFactory;
import com.linkedbear.architecture.k_filtermethod.service.DemoService;
import com.linkedbear.architecture.k_filtermethod.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/demo11")
public class DemoServlet11 extends HttpServlet {
    
    DemoService demoService;
    
    @Override
    public void init() throws ServletException {
        // 读取proxy.properties
        Properties proxyProp = new Properties();
        try {
            proxyProp.load(this.getClass().getClassLoader().getResourceAsStream("proxy.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("DemoServlet11 initialize error, cause: " + e.getMessage());
        }
    
        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        Class<? extends DemoService> clazz = demoService.getClass();
        this.demoService = (DemoService) Proxy
                .newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
                    List<String> list = Arrays.asList(proxyProp.getProperty("log.methods").split(","));
                    if (list.contains(method.getName())) {
                        LogUtils.printLog("DemoService", method.getName(), args);
                    }
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

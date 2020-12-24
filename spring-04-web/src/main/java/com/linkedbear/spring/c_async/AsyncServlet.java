package com.linkedbear.spring.c_async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AsyncServlet doGet ......" + Thread.currentThread().getName());
        PrintWriter writer = resp.getWriter();
        
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            System.out.println("AsyncServlet asyncContext ......" + Thread.currentThread().getName());
            
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ignore) { }
            asyncContext.complete();
            
            writer.println("success");
            System.out.println("AsyncServlet asyncContext end ......" + Thread.currentThread().getName());
        });
        
        System.out.println("AsyncServlet doGet end ......" + Thread.currentThread().getName());
    }
}

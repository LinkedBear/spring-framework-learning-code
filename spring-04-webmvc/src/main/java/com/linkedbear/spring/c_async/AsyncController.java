package com.linkedbear.spring.c_async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@RestController
public class AsyncController {
    
    @GetMapping("/async")
    public Callable<String> async() {
        System.out.println("AsyncController async ......" + Thread.currentThread().getName());
        return () -> {
            System.out.println("AsyncController Callable ......" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            return "AsyncController async ......";
        };
    }
    
    private DeferredResult<String> deferredResult = null;
    
    @GetMapping("/deferred")
    public DeferredResult<String> deferred() {
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        this.deferredResult = deferredResult;
        return deferredResult;
    }
    
    @GetMapping("/addData")
    public void addData() {
        if (this.deferredResult != null) {
            this.deferredResult.setResult("AsyncController deferredResult setResult");
            this.deferredResult = null;
        }
    }
}

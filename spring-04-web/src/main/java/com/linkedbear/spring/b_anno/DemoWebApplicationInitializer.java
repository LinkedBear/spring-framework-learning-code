package com.linkedbear.spring.b_anno;

import com.linkedbear.spring.b_anno.config.UserConfiguration;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class DemoWebApplicationInitializer extends AbstractContextLoaderInitializer {
    
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(UserConfiguration.class);
        return ctx;
    }
}

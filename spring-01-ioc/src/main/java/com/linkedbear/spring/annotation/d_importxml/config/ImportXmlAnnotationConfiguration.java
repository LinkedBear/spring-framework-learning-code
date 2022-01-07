package com.linkedbear.spring.annotation.d_importxml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:annotation/import-anno.xml")
public class ImportXmlAnnotationConfiguration {
    
}

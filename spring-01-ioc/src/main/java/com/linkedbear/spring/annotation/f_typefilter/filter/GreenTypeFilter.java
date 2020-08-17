package com.linkedbear.spring.annotation.f_typefilter.filter;

import com.linkedbear.spring.annotation.f_typefilter.color.Green;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class GreenTypeFilter implements TypeFilter {
    
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        return classMetadata.getClassName().equals(Green.class.getName());
    }
}

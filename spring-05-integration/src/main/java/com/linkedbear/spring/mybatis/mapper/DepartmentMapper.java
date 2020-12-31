package com.linkedbear.spring.mybatis.mapper;

import com.linkedbear.spring.mybatis.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    
    void save(Department department);
    
    List<Department> findAll();
}

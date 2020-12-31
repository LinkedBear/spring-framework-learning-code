package com.linkedbear.spring.data.jpa.dao;

import com.linkedbear.spring.data.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
    
}

package com.linkedbear.spring.withdao.service;

import com.linkedbear.spring.withdao.dao.DepartmentDao;
import com.linkedbear.spring.withdao.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentService {
    
    @Autowired
    DepartmentDao departmentDao;
    
    public void save(Department department) {
        departmentDao.save(department);
    }
    
    public void deleteById(String id) {
        departmentDao.deleteById(id);
    }
    
    public List<Department> findDepartmentsByName(String name) {
        Department query = new Department();
        query.setName(name);
        return departmentDao.findDepartments(query);
    }
    
    public List<Department> findDepartments(Department query) {
        if (query == null) {
            return departmentDao.findAllDepartments();
        }
        return departmentDao.findDepartments(query);
    }
    
    public Department findById(String id) {
        return departmentDao.findById(id);
    }
}

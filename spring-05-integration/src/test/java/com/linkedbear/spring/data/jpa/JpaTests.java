package com.linkedbear.spring.data.jpa;

import com.linkedbear.spring.data.jpa.dao.DepartmentDao;
import com.linkedbear.spring.data.jpa.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:data/spring-data-jpa.xml")
public class JpaTests {
    
    @Autowired
    DepartmentDao departmentDao;
    
    @Test
    public void testSave() {
        Department department = new Department();
        department.setName("test department");
        department.setTel("1122334");
        departmentDao.save(department);
    }
    
    @Test
    public void testFindAll() {
        System.out.println("testFindAll ......");
        List<Department> departmentList = departmentDao.findAll();
        departmentList.forEach(System.out::println);
    }
    
    @Test
    public void testDelete() {
    	departmentDao.deleteById(1);
    }
}

package com.linkedbear.spring.mybatis;

import com.linkedbear.spring.mybatis.dao.DepartmentDao;
import com.linkedbear.spring.mybatis.entity.Department;
import com.linkedbear.spring.mybatis.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:mybatis/spring-mybatis.xml")
public class MyBatisTests {
    
    @Autowired
    DepartmentDao departmentDao;
    
    @Autowired
    DepartmentMapper departmentMapper;
    
    @Test
    public void testDaoSave() {
        Department department = new Department();
        department.setName("mybatis dao name");
        department.setTel("mybatis dao tel");
        departmentDao.save(department);
    }
    
    @Test
    public void testDaoFindAll() {
        System.out.println(departmentDao.findAll());
    }
    
    @Test
    public void testMapperSave() {
        Department department = new Department();
        department.setName("mybatis dao name");
        department.setTel("mybatis dao tel");
        departmentMapper.save(department);
    }
    
    @Test
    public void testMapperFindAll() {
        System.out.println(departmentMapper.findAll());
    }
}

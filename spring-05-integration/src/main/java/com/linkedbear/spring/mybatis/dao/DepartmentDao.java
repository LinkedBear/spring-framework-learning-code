package com.linkedbear.spring.mybatis.dao;

import com.linkedbear.spring.mybatis.entity.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {
    
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
    public void save(Department department) {
//        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//            sqlSession.insert("dept.save", department);
//        }
        sqlSessionTemplate.insert("dept.save", department);
    }
    
    public List<Department> findAll() {
//        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//            return sqlSession.selectList("dept.findAll");
//        }
        return sqlSessionTemplate.selectList("dept.findAll");
    }
}

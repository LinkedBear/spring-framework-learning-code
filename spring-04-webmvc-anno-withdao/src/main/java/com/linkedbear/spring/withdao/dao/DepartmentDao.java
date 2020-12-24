package com.linkedbear.spring.withdao.dao;

import com.linkedbear.spring.withdao.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DepartmentDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public int save(Department department) {
        return jdbcTemplate.update("insert into tbl_dept (id, name, tel) values (?, ?, ?)",
                UUID.randomUUID().toString().replaceAll("-", ""), department.getName(), department.getTel());
    }
    
    public int deleteById(String id) {
        return jdbcTemplate.update("delete from tbl_dept where id = ?", id);
    }
    
    public List<Department> findAllDepartments() {
        return jdbcTemplate.query("select * from tbl_dept", new BeanPropertyRowMapper<>(Department.class));
    }
    
    public List<Department> findDepartments(Department query) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>(3);
        sql.append("select * from tbl_dept where 1 = 1");
        if (query.getId() != null) {
            sql.append(" and id = ?");
            params.add(query.getId());
        }
        if (StringUtils.hasText(query.getName())) {
            sql.append(" and name like concat('%', ?, '%')");
            params.add(query.getName());
        }
        return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(Department.class));
    }
    
    public Department findById(String id) {
        List<Department> departments = jdbcTemplate
                .query("select * from tbl_dept where id = ?", new BeanPropertyRowMapper<>(Department.class), id);
        return departments.size() > 0 ? departments.get(0) : null;
    }
}

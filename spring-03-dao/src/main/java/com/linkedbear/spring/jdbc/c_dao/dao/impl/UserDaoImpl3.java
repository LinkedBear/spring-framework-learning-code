package com.linkedbear.spring.jdbc.c_dao.dao.impl;

import com.linkedbear.spring.jdbc.b_crud.bean.User;
import com.linkedbear.spring.jdbc.c_dao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl3 extends JdbcDaoSupport implements UserDao {
    
    @Autowired
    public UserDaoImpl3(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    @Override
    public void save(User user) {
        this.getJdbcTemplate().update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }
    
    @Override
    public User findById(Integer id) {
        List<User> userList = this.getJdbcTemplate()
                .query("select * from tbl_user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return userList.size() > 0 ? userList.get(0) : null;
    }
    
    @Override
    public List<User> findAll() {
        return this.getJdbcTemplate().query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }
}

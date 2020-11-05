package com.linkedbear.architecture.f_pointslog.dao.impl;

import com.linkedbear.architecture.f_pointslog.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}

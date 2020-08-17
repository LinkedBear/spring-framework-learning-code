package com.linkedbear.architecture.e_cachedfactory.dao.impl;

import com.linkedbear.architecture.e_cachedfactory.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}

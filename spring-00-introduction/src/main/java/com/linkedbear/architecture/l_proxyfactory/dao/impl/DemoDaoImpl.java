package com.linkedbear.architecture.l_proxyfactory.dao.impl;

import com.linkedbear.architecture.l_proxyfactory.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}

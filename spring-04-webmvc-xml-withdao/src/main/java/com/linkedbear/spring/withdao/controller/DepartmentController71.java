package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.Department;
import com.linkedbear.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
@RequestMapping("/department")
public class DepartmentController71 {
    
    @Autowired
    DepartmentService departmentService;
    
    @RequestMapping("/list")
    public String list(HttpServletRequest request, String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
    
    @RequestMapping("/delete")
    public String delete(String id) {
        departmentService.deleteById(id);
        return "redirect:/department/list";
    }
    
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/deptInfo";
    }
    
    @RequestMapping("/save")
    public String save(Department department) {
        System.out.println(department);
        return "redirect:/department/list";
    }
    
    @RequestMapping("/get")
    public void get(HttpServletResponse response, String id) throws IOException {
        Department department = departmentService.findById(id);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println("department序列化后的json");
    }
}

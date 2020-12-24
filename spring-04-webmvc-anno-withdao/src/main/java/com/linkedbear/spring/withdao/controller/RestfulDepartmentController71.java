package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.Department;
import com.linkedbear.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//@Controller
@RequestMapping("/department")
public class RestfulDepartmentController71 {
    
    @Autowired
    DepartmentService departmentService;
    
    @GetMapping("/list")
    public String list(HttpServletRequest request, String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Department findById(@PathVariable("id") String id) {
        return departmentService.findById(id);
    }
    
    @PostMapping("/")
    public void save(@RequestBody Department department) {
        departmentService.save(department);
    }
    
    @PutMapping("/{id}")
    public void update(Department department, @PathVariable("id") String id) {
        // update ......
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        departmentService.deleteById(id);
    }
}

package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.Department;
import com.linkedbear.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
public class JsonDepartmentController72 {
    
    @Autowired
    DepartmentService departmentService;
    
    @GetMapping("/department/list")
    public String list(HttpServletRequest request, String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
    
    @PostMapping("/department/saveJson")
    @ResponseBody
    public void saveJson(@RequestBody Department department) {
        System.out.println(department);
    }
    
    @RequestMapping("/department/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/deptInfo";
    }
    
    @RequestMapping("/department/save")
    public String save(Department department) {
        System.out.println(department);
        return "redirect:/department/list";
    }
    
    @RequestMapping("/department/save2")
    public void save2(HttpServletRequest request, HttpServletResponse response, Department department)
            throws IOException, ServletException {
        System.out.println(department);
//        request.getRequestDispatcher(request.getContextPath() + "/department/list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/department/list");
    }
    
    @Autowired
    HttpServletRequest request;
    
    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        return servletRequestAttributes.getRequest();
    }
}

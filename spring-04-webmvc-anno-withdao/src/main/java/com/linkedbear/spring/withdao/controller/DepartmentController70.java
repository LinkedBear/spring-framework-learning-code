package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.Department;
import com.linkedbear.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@Controller
public class DepartmentController70 {
    
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    HttpServletRequest request;
    
    /*
    @RequestMapping("/department/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("deptList", departmentService.findDepartments(null));
        return "dept/deptList";
    }
     */
    
    /*
    // 基于request和原生类型的请求参数绑定
    @RequestMapping("/department/list")
    public String list(HttpServletRequest request, @RequestParam(value = "dept_name") String name) {
        // String name = request.getParameter("name");
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
    */
    
    /*
    // 基于模型类的请求参数绑定
    @RequestMapping("/department/list")
    public String list(Department dept) {
        request.setAttribute("deptList", departmentService.findDepartments(dept));
        return "dept/deptList";
    }
    */
    
    @RequestMapping("/department/list2")
    public ModelAndView list2(ModelAndView mav) {
        mav.addObject("deptList", departmentService.findDepartments(null));
        mav.setViewName("dept/deptList");
        return mav;
    }
    
    @RequestMapping("/department/list3")
    public String list3(ModelMap map) {
        map.put("deptList", departmentService.findDepartments(null));
        return "dept/deptList";
    }
    
    
    // ------------------------------------------------------
    // ------------------------------------------------------
    // ------------------------------------------------------
    
    
    @RequestMapping("/department/list")
    public String list(String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
    
    @RequestMapping("/department/delete")
    public String delete(String id) {
        departmentService.deleteById(id);
        return "dept/deptList";
    }
    
    @RequestMapping("/department/edit")
    public String edit(String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/deptInfo";
    }
    
    @RequestMapping("/department/save")
    public String save(Department department) {
        System.out.println(department);
        return "dept/deptList";
    }
}

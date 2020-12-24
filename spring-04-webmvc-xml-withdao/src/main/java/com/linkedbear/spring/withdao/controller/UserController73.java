package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.User;
import com.linkedbear.spring.withdao.service.DepartmentService;
import com.linkedbear.spring.withdao.service.UserService;
import com.linkedbear.spring.withdao.validation.UserInfoGroup;
import com.linkedbear.spring.withdao.validation.UserPasswordGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
@RequestMapping("/user")
public class UserController73 {
    
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    
    @GetMapping("/list")
    public String list(ModelMap map) {
        map.put("userList", userService.findAllUsers());
        return "user/userList";
    }
    
    @GetMapping("/edit")
    public String edit(HttpServletRequest request, @NotBlank String id) {
        request.setAttribute("user", userService.findById(id));
        request.setAttribute("deptList", departmentService.findDepartments(null));
        return "user/userInfo";
    }
    
    @PostMapping("/save")
    public String save(@Validated(UserPasswordGroup.class) User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            throw new RuntimeException("数据格式不正确！");
        }
        System.out.println(user);
        return "redirect:/user/list";
    }
    
    @PostMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") List<String> ids) {
//        System.out.println(Arrays.toString(ids));
        System.out.println(ids);
        return "success";
    }
    
    @PostMapping("/batchUpdate")
    public String batchUpdate(UsersVO users) {
        users.getUsers().forEach(System.out::println);
        return "redirect:/user/list";
    }
    
    public static class UsersVO {
        private List<User> users;
    
        public List<User> getUsers() {
            return users;
        }
    
        public void setUsers(List<User> users) {
            this.users = users;
        }
    }
}

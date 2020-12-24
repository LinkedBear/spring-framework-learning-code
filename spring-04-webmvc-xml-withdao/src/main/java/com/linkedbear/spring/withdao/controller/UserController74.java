package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.User;
import com.linkedbear.spring.withdao.service.DepartmentService;
import com.linkedbear.spring.withdao.service.UserService;
import com.linkedbear.spring.withdao.validation.UserPasswordGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

//@Controller
@RequestMapping("/user")
public class UserController74 {
    
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
    public String save(User user, MultipartFile photoFile) throws IOException {
        System.out.println(user);
        
        // 获取原始文件名
        String originalFilename = photoFile.getOriginalFilename();
        // 获取文件扩展名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        
        // 图片保存至本地
        // String filename = UUID.randomUUID().toString() + ext;
        // File file = new File("E:/temp/" + filename);
        // photoFile.transferTo(file);
        
        user.setPhoto(photoFile.getBytes());
        // 保存到数据库
        userService.update(user);
        
        return "redirect:/user/list";
    }
    
    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(String id) throws UnsupportedEncodingException {
        User user = userService.findById(id);
        byte[] photo = user.getPhoto();
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(user.getUsername() + ".jpg", "utf-8"));
        return new ResponseEntity<>(photo, headers, HttpStatus.CREATED);
    }
}

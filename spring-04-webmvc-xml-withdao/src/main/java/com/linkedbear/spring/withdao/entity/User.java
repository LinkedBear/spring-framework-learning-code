package com.linkedbear.spring.withdao.entity;

import com.linkedbear.spring.withdao.validation.UserInfoGroup;
import com.linkedbear.spring.withdao.validation.UserPasswordGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class User {
    
    private String id;
    
    /*
    @NotBlank(message = "用户名不能为空", groups = {UserInfoGroup.class, UserPasswordGroup.class})
    @Length(min = 6, max = 20, message = "用户名的长度必须为6-20位", groups = {UserInfoGroup.class, UserPasswordGroup.class})
    private String username;
    
    @NotBlank(message = "用户姓名不能为空", groups = UserInfoGroup.class)
    private String name;
    */
    
    @NotBlank(message = "{user.username.notblank}", groups = {UserInfoGroup.class, UserPasswordGroup.class})
    @Length(min = 6, max = 20, message = "{user.username.length}", groups = {UserInfoGroup.class, UserPasswordGroup.class})
    private String username;
    
    @NotBlank(message = "{user.name.notblank}", groups = UserInfoGroup.class)
    private String name;
    
    private Date birthday;
    
    private byte[] photo;
    
    private Department department;
    
    @Override
    public String toString() {
        return "User{"
                + "id='"
                + id
                + '\''
                + ", username='"
                + username
                + '\''
                + ", name='"
                + name
                + '\''
                + ", birthday="
                + ZonedDateTime.ofInstant(birthday.toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + ", department="
                + department
                + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public byte[] getPhoto() {
        return photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
}

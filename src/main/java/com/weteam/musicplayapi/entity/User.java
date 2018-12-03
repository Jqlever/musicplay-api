package com.weteam.musicplayapi.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

public class User {

    private Integer id;
    private String userName;
    private Boolean sex;
    @NotEmpty(message = "邮箱不能为空")
    @Email
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private Integer isRoot;
    private Date createTime;
    private Date modifyTime;

    public User() {
    }

    public User(Integer id, String userName, Boolean sex, String email, String password, Date createTime, Date modifyTime) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}

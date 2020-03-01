package com.library.entity;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Reader {
    private Integer readerid;

    private String readerkey;

    private Integer type;

    private String typename;

    private String name;

    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    private Integer age;

    private String sex;

    private String phone;

    private String dept;

    @JSONField(format="yyyy-MM-dd")
    private Date regdate;

    private Integer borrownum;

    private Integer allborrownum;

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public String getReaderkey() {
        return readerkey;
    }

    public void setReaderkey(String readerkey) {
        this.readerkey = readerkey == null ? null : readerkey.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getBorrownum() {
        return borrownum;
    }

    public void setBorrownum(Integer borrownum) {
        this.borrownum = borrownum;
    }

    public Integer getAllborrownum() {
        return allborrownum;
    }

    public void setAllborrownum(Integer allborrownum) {
        this.allborrownum = allborrownum;
    }
}
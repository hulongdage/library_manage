package com.library.entity;

public class Booktype {
    private Integer id;

    private String typename;

    private Integer typeborronum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getTypeborronum() {
        return typeborronum;
    }

    public void setTypeborronum(Integer typeborronum) {
        this.typeborronum = typeborronum;
    }
}
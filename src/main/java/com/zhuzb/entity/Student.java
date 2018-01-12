package com.zhuzb.entity;

import com.zhuzb.util.Pager;

import java.io.Serializable;

public class Student extends Pager implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

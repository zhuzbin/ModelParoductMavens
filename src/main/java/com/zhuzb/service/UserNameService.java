package com.zhuzb.service;

import com.zhuzb.entity.UserName;

import java.util.List;

public interface UserNameService{
    public void saveStu(UserName student);

    public List<UserName> getList();
}

package com.zhuzb.dao;

import java.util.Map;

/**
 * Desc：用户操作
 * User：ZhuZhiBin
 * Date：2017/12/29
 * Time：10:53
 */
public interface UserDao {

    public Map<String,Object> getUser(String id);
}

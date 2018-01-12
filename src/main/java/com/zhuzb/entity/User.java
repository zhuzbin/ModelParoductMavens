package com.zhuzb.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Desc：基本用户实体
 * User：ZhuZhiBin
 * Date：2017/11/27
 * Time：17:35
 */
public class User {
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String locked;

    private Set<Role> roleSet = new HashSet<Role>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

}

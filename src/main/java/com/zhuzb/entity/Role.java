package com.zhuzb.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Desc：角色实体
 * User：ZhuZhiBin
 * Date：2017/11/27
 * Time：17:36
 */
public class Role {
    private Integer id;

    private String role;

    private String description;

    private Integer available;

    private Set<User> userSet = new HashSet<User>();

    private Set<Permissions> permissionsSet = new HashSet<Permissions>();

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Permissions> getPermissionsSet() {
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}

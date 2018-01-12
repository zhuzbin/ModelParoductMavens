package com.zhuzb.entity;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

/**
 * Desc：权限实体
 * User：ZhuZhiBin
 * Date：2017/11/27
 * Time：18:02
 */
public class Permissions {
    private Integer id;

    private String permission;

    private String description;

    private Integer available;

    private Set<Role> roleSet = new HashSet<Role>();

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

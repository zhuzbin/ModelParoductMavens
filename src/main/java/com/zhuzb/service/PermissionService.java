package com.zhuzb.service;

import org.apache.shiro.authz.Permission;

/**
 * Desc：权限接口
 * User：ZhuZhiBin
 * Date：2017/11/27
 * Time：17:22
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}

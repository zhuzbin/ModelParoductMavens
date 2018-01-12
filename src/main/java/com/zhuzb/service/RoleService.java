package com.zhuzb.service;

/**
 * Desc：角色基本接口
 * User：ZhuZhiBin
 * Date：2017/11/27
 * Time：17:24
 */
public interface RoleService {

    public void createRole();

    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId,Long... permissionIds);

    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}

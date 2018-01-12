<#assign className = "">
<#list tableName?split("_") as x>
    <#assign className = className+(x?cap_first)>
</#list>
package com.zhuzb.dao;


public interface ${className}{
    public
}
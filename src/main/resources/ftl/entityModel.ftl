<#assign className = "">
<#list tableName?split("_") as x>
    <#assign className = className+(x?cap_first)>
</#list>
package com.zhuzb.entity;

import java.io.Serializable;

public class ${className} implements Serializable{

<#assign type = "">
<#-- 设置属性 -->
<#list student as col>
    <#assign colunmNames = "">
    <#if col.dataType == "varchar">
        <#assign type = "String">
    <#elseif col.dataType == "bigint">
        <#assign type = "int">
    </#if>
    <#list col.columnName?split("_") as x>
        <#assign colunmNames = colunmNames+(x?cap_first)>
    </#list>
    private ${type} ${colunmNames?uncap_first};     //${col.columnComment}
</#list>

<#-- 设置get和set -->
<#list student as col>
    <#assign colunmNames = "">
    <#list col.columnName?split("_") as x>
        <#assign colunmNames = colunmNames+(x?cap_first)>
    </#list>

<#-- 设置set -->
    public void set${colunmNames}(${type} ${colunmNames?uncap_first}){
        this.${colunmNames?uncap_first} = ${colunmNames?uncap_first};
    }

<#--- 设置get --->
    public ${type} get${colunmNames}(){
        return ${colunmNames?uncap_first};
    }
</#list>
}
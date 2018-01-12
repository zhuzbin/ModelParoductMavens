<#--
modelName:实体名称
-->
package com.zhuzb.service;

import com.zhuzb.entity.${modelName};

import java.util.List;

public interface ${modelName}Service{
    public void saveStu(${modelName} student);

    public List<${modelName}> getList();
}

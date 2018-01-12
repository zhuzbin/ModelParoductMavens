<#assign className = "">
<#list tableName?split("_") as x>
    <#assign className = className+(x?cap_first)>
</#list>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <class name="com.zhuzb.entity.${className}" table="${tableName}">
<#list student as col>
    <#assign colunmNames = "">
    <#if col.dataType == "varchar">
        <#assign type = "String">
    <#elseif col.dataType == "bigint">
        <#assign type = "Integer">
    </#if>
    <#list col.columnName?split("_") as x>
        <#assign colunmNames = colunmNames+(x?cap_first)>
    </#list>
    <#if col.columnKey == "PRI">
        <id name="${colunmNames?uncap_first}" type="java.lang.${type}">
            <generator class="uuid" />
        </id>
    <#else>
        <property name="${colunmNames?uncap_first}" type="java.lang.${type}">
            <column name="${col.columnName}" length="${col.characterMaximumLength}"></column>
        </property>
    </#if>
</#list>
    </class>
</hibernate-mapping>
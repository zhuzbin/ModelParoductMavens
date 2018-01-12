package com.zhuzb.util;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * AOP切面类
 * @author T440
 *
 */
public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
	private static Logger logger = Logger.getLogger(DataSourceAdvice.class);
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object target) throws Throwable {
		DynamicContextChange.clearCustomerType();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {


		if (method.getName().startsWith("freeMarker") || method.getName().startsWith("free") ) {
			
			logger.info("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法");
			
			DynamicContextChange.setDataSourceTypeSlave();
		}
	}
	// 抛出Exception之后被调用  
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {  
    	DynamicContextChange.clearCustomerType();  
    }  
}

package com.cyh.demos.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokationHandler1 implements InvocationHandler{

	//需要被代理的对象
	private Object target;
	public void setTarget(Object target){
		this.target = target;
	}
	
	//执行动态代理对象的所有方法时,都会被代理成执行如下的invoke方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		DogUtil util = new DogUtil();
		util.method1();
		Object result = method.invoke(proxy, args);
		util.method2();
		return result;
	}

}

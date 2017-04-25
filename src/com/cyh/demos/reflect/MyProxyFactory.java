package com.cyh.demos.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyFactory {
	public static Object getProxy(Object target){
		MyInvokationHandler1 handler1 = new MyInvokationHandler1();
		handler1.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader()
				, target.getClass().getInterfaces() ,handler1);
	}
}

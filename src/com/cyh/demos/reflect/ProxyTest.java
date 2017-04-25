package com.cyh.demos.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.acl.Permission;

interface Person{
	void walk();
	void sayHello(String name);
}
class MyInvokationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("----------执行" + method + "方法------");
		if(args != null){
			System.out.println("下面是执行方法时传入的实参");
			for(Object val : args){
				System.out.println(val);
			}
		}
		else {
			System.out.println("调用该方法没有实参");
		}
		return null;
	}
	
}
public class ProxyTest {

	public static void main(String[] args) {
		InvocationHandler handler = new MyInvokationHandler();
		//使用指定的InvocationHandler来生成指定的动态代理对象
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader()
				, new Class[]{Person.class}, handler);
		
		p.walk();
		p.sayHello("cyh");

	}

}

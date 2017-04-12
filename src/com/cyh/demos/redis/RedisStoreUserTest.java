package com.cyh.demos.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import redis.clients.jedis.Jedis;

public class RedisStoreUserTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//创建jedis对象
		Jedis jedis = new Jedis("192.168.153.129");
		
		User user = new User("蔡于慧", 28);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		
		oos.writeObject(user);
		//把字节流输出到redis中
		jedis.set("user".getBytes(), baos.toByteArray());
		
		//下面开始反序列化操作
		byte[] byts = jedis.get("user".getBytes());
		ByteArrayInputStream bais = new ByteArrayInputStream(byts);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object object = ois.readObject();
		
		if(object instanceof User){
			User user1 = (User)object;
			System.out.println("username:" + user1.getUserName()
					+ "=====" + "age:" + user1.getAge());
		}
		

	}

}

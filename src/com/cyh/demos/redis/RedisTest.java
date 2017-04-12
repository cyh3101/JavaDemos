package com.cyh.demos.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.153.129");
		//jedis.auth("123456");
		System.out.println("Server is running:" + jedis.ping());
		
		jedis.set("cyh", "蔡于慧");
		System.out.println(jedis.get("cyh"));
	}

}

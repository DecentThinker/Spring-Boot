package com.example.SpringRedis;

import com.example.SpringRedis.config.User;
import com.example.SpringRedis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRedisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	@Autowired
	RedisUtil redisUtil;

	@Override
	public void run(String... args) throws Exception {
//		redisUtil.setExpirablekey("Name","Robin");
//		System.out.println("Data set in redis");

//		redisUtil.setExpirablekey("2","Aman", 50);

//		String data = redisUtil.getDataFromRedis("Name");
//		System.out.println("Data from Redis:"+data);

//		String data = redisUtil.getDataFromRedis("2");
//		System.out.println("Data from Redis:"+data);

//		User user  = new User(1,"Aman","aman@gmail.com");
//		redisUtil.setExpirablekey("aman",user,50);
//		System.out.println("dat saved");

		User userResult = redisUtil.getDataFromRedis("aman");
		System.out.println(userResult);
	}
}

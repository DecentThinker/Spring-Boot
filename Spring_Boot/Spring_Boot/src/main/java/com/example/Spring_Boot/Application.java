package com.example.Spring_Boot;

import com.example.profile.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//this annotation will be enough to replace all 3 - Configuration, ComponentScan, EnableAutoConfiguration.
//@SpringBootApplication

@Configuration
@ComponentScan("com.example") // To allow Controller classes to be placed in package other than default.

//In order to exclude dispatcher servlet uncomment the following lines doing so , hitting of API will give 404 error.
//@EnableAutoConfiguration(exclude={DispatcherServletAutoConfiguration.class, ErrorMvcAutoConfiguration.class})

@EnableAutoConfiguration
public class Application implements CommandLineRunner
{
	//using qualifier annotation to declare which type of bean we want of type DbConnect if there are multiple profiles
	@Autowired
//			@Qualifier("develpmentDatabase")
	DbConnect dbConnect;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dbConnect.connectWithDatabase();
	}
}

package com.example.Spring_JPA;

import com.example.Spring_JPA.model.Student;
import com.example.Spring_JPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		Student student = new Student();
//		student.setName("Aman");
//		student.setMail("aman@gmail.com");
//
//		studentRepository.save(student);
//		System.out.println("Data Saved");

		//findById method returns an optional class therefore we need to further call get method.
//		Student st;
//		st = studentRepository.findById(1).get();
//		System.out.println(st);
//
//		studentRepository.deleteById(1);
//		System.out.println("Deleted data");

		Student st ;
//		st = studentRepository.findByName("Aman");
//		System.out.println(st);

//		st = studentRepository.findByNameAndMail("Aman", "aman@gmail.com");
//		System.out.println(st);

		st = studentRepository.findByNameJPQL("Mohammad");
		System.out.println(st);

		// Update Query
//		studentRepository.updateName("Aman","Mohammad");
//		st = studentRepository.findByNameNative("Mohammad");
//		System.out.println(st);




	}
}

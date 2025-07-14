package com.example.SpringBoot_JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner
{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
//		String query = "Insert into users(username, email, pass) values(?,?,?)";
//
//		Student student = new Student("harshita","harshita@gmail.com","abcde");
//
//		int rows = jdbcTemplate.update(query, student.getUsername(), student.getEmail(), student.getPassword());
//
//		System.out.println(rows);

		String query = "select * from users where username = 'laxmi'";
		Student student = jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student map = new Student();
				map.setUsername(rs.getString(1));
				map.setEmail(rs.getString(2));
				map.setPassword(rs.getString(3));

				return map;
			}
		});

		System.out.println(student);

//		String query = "select * from users";
//		List students = jdbcTemplate.query(query,new StudentRowMapper());
//
//		System.out.println(students);

//		String query = "SELECT * FROM users";
//		List<Map<String, Object>> students = jdbcTemplate.queryForList(query);
//
//		for (Map<String, Object> row : students) {
//			System.out.println(row);
//		}
//
		//Update

//		String query  = "Update users set email = 'laxmibai@gmail.com' where username='laxmi'";
//
//		int rows = jdbcTemplate.update(query);
//
//		System.out.println(rows);


	}
}

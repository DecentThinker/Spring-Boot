package com.example.service;

import com.example.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
//marks a class as a service layer component, indicating its role in business logic and making it eligible
//for Spring's component scanning and dependency injection

public class StudentService
{
    static List<Student> studentList = new ArrayList<>();

    static
    {
        studentList.add(new Student(1,"Aman", "aman@gmail.com"));
        studentList.add(new Student(2,"Shayan", "shsyan@gmail.com"));
        studentList.add(new Student(3,"Anuroop", "anuroop@gmail.com"));
    }
    public List<Student> getAllStudents()
    {
        return studentList;
    }

    public Student getStudentById(int id)
    {
        for(Student student: studentList)
        {
            if(student.getId()==id)
                return student;
        }
        return null;
    }
}

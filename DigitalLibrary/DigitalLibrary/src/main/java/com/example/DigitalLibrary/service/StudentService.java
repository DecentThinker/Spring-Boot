package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.model.Student;
import com.example.DigitalLibrary.model.StudentType;
import com.example.DigitalLibrary.repository.StudentDao;
import com.example.DigitalLibrary.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentDao studentDao;

    public Student createStudentForLibrary(CreateStudentRequest request)
    {
        String id = request.getStudentId();
        String type = request.getStudentType().toString();
        String name = request.getName();
        String email = request.getEmail();
        String phone = request.getPhoneNo();

        Student student = Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type)).
                email(email).name(name).phoneNo(phone).build();

        int row = studentDao.createStudentInDatabase(student);


    }

}

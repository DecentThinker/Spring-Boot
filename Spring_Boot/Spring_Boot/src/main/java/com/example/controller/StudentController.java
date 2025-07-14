package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // To mark this class as Controller class.

// A REST API (Representational State Transfer Application Programming Interface) is a web service that follows
// REST principles, enabling communication between client and server over HTTP by using stateless operations
// and standard HTTP methods (GET, POST, PUT, DELETE) to perform CRUD (Create, Read, Update, Delete) operations
// on resources represented as URLs.

@RequestMapping("/student") // it forms the base URl for this Controller class

//if we try to put simpleController in other package like here in controller package then we need to use
//componentScan in default Spring_Boot Application class and mention the parent package name there.

public class StudentController
{
    //for auto creation of bean of StudentService Class
    @Autowired
    StudentService studentService;

    //for logging purposes
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    // To produce the result as XML type in Postman , we have also added a dependency in pom.xml file
    // XML can handle mixed content, where text and child elements are interspersed,
    // making it ideal for documents that combine structured and unstructured data.
    // Read more about this later.

    @GetMapping(value = "/get/students" ,produces = MediaType.APPLICATION_XML_VALUE)
    public List<Student> getStudents()
    {
       return studentService.getAllStudents();
    }

    //We can pass2 types of variables in query .
    //1. path Variable - If we want to send some important and required information for the task.
    //2. Query parameter  - To send extra information if required which might not be necessary for carrying out that task.
    // often used for filtering and customising . Ex - GET /users?age=30&location=NY

    // Instead of returning just student object, here we are returning ResponseEntity<> which helps to send status codes.
    //along with result. which is useful when someone hits API with some invalid sid.
    @GetMapping("/get/student/id/{sid}")
    public ResponseEntity<Student> getStudent(@PathVariable("sid") String id)
    {
        // default debugging level is info,
        // ALL > TRACE > DEBUG > INFO > WARN > ERROR > FATAL > OFF
        // if we chose any warn then info logs won't be printed.
        logger.info("Request Received");
        logger.debug("Request Received");
        logger.error("Request Received");
        logger.warn("Request Received");
        logger.trace("Request Received");

        int sid = Integer.parseInt(id);
        Student student = studentService.getStudentById(sid);
        if(student==null)
        {
            logger.info("Doesn't Exist");
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        }
        else
        {
            logger.info("Student exists");
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
}

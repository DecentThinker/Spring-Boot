package com.example.JUnitAndMockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//it also loads Application Context
class PersonTest {

    @Autowired
    TestController testController;

    Person person;
    @Test
    void eat()
    {
        Person person  = new Person();
        String result = person.eat();
        Assertions.assertEquals("person is eating", result);
        System.out.println("Inside the eat test method");
    }

    @Test
    void eat2()
    {
        String result = person.eat();
        Assertions.assertEquals("person is eating", result);
        System.out.println("Inside the eat test method 2");
    }

    @BeforeEach
    public void beforeEachMethodTest()
    {
        person = new Person();
        System.out.println("Before Each Method Called");
    }

    @Test
    //If we run this test method without using @SpringBootTest annotation it won't load application Context
    //and TestController object won't be autowired ;
    void checkTestController()
    {
        String result = testController.getTestData();
        Assertions.assertEquals("Test Data",result);
    }
}
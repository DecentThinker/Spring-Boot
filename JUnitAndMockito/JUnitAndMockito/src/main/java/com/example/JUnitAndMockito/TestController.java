package com.example.JUnitAndMockito;

import org.springframework.stereotype.Component;

@Component
public class TestController
{
    public String getTestData()
    {
        return "Test Data";
    }
}

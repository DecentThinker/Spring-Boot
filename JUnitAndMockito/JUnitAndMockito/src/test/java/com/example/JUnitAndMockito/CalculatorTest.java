package com.example.JUnitAndMockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorTest {

    @Test
    void add()
    {
        Calculator calculator = new Calculator();
        int result = calculator.add(3,5);
        Assertions.assertEquals(8,result);
    }

    @Test
    void subtract()
    {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(3,5);
        Assertions.assertEquals(-2,result);
    }

    @Test
    void divide()
    {
        Calculator calculator = new Calculator();
        int result = calculator.divide(3,5);
        Assertions.assertEquals(0,result);
    }

    @ParameterizedTest
    @ValueSource(ints={3, 7, 9, 11, 13})
    void isOdd(int val)
    {
        Calculator calculator = new Calculator();
        boolean result  = calculator.isOdd(val);
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @CsvSource({"2,3,5","5,3,8","2,2,4","1,3,8"})
    public void addTestMultiple(int a, int b, int expected)
    {
        Calculator calculator = new Calculator();
        int result = calculator.add(a,b);
        Assertions.assertEquals(expected,result);

    }
    @ParameterizedTest
    @CsvFileSource(resources = "/calci_testCases.csv", numLinesToSkip = 1)
    public void addTestCSVFile(int a, int b, int expected)
    {
        Calculator calculator = new Calculator();
        int result = calculator.add(a,b);
        Assertions.assertEquals(expected,result);

    }
}
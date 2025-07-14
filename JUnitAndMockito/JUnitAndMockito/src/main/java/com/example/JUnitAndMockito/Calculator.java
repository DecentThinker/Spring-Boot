package com.example.JUnitAndMockito;

public class Calculator
{
    int add(int a, int b)
    {
        return a+b;
    }

    int subtract(int a, int b)
    {
        return a-b;
    }

    int divide(int a, int b)
    {
        return a/b;
    }

    public boolean isOdd(int val)
    {
        return val%2==1;
    }
}

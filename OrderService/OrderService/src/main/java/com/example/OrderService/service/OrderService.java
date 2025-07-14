package com.example.OrderService.service;

import com.example.OrderService.order.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService
{
    static List<Order> orderList;
    static{
        Order order1 = new Order(1,1, "1001", "Iphone","this is iphone",55000, new Date());
        Order order2 = new Order(1,2, "1002", "Macbook Air","this is Macbook",95000, new Date());
        Order order3 = new Order(1,3, "1003", "Samsung","this is Samsung",125000, new Date());
        Order order4 = new Order(2,4, "1004", "Ipad","this is Ipad",35000, new Date());

        orderList = Arrays.asList(order1, order2, order3, order4);
    }

    public List<Order> getOrderByUserId(int id)
    {
        List<Order> orders = new ArrayList<>();

        for(Order order:orderList)
        {
            if(order.getUserId()==id)
            {
                orders.add(order);
            }
        }
        return orders;
    }
}

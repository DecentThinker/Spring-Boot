package com.example.OrderService.controller;

import com.example.OrderService.order.Order;
import com.example.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController
{
    @Autowired
    OrderService orderService;


    public List<Order> getOrderList(@PathVariable("userid") String userId)
    {
        return orderService.getOrderByUserId(Integer.parseInt(userId));
    }
}

package com.example.UserService.service;

import com.example.UserService.model.Order;
import com.example.UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.UserService.feign.FeignClient;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FeignClient feignClient;

    static List<User> userList;
    static{
        User user1 = new User(1,"Aman","aman@gmail.com","112",null);
        User user2 = new User(2,"Nidhi","Nidhi@gmail.com","113",null);
        User user3 = new User(3,"Ayush","Ayush@gmail.com","114",null);
        User user4 = new User(4,"Mehvish","Mehvish@gmail.com","115",null);
        User user5 = new User(5,"Mehvish","Mehvish@gmail.com","116",null);

        userList = Arrays.asList(user1, user2, user3, user4, user5);

    }

    public User getUserById(int id)
    {
        User userData = null;

        for(User user: userList)
        {
            if(user.getId()==id)
            {
                userData = user;
                break;
            }
        }
        if(userData==null)
            return null;

        //List<Order> orderList = restTemplate.getForObject("http://ORDER-SERVICE/order-service/get/orders/"+id,List.class);

        List<Order> orderList = feignClient.getOrderList(Integer.toString(id));
        userData.setOrderList(orderList);
        return  userData;
    }
}

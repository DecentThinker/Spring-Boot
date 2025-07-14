package com.example.UserService.feign;

import com.example.UserService.model.Order;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name="ORDER-SERVICE")
public interface FeignClient
{
    @GetMapping("/order-service/get/orders/{userid}")
    List<Order> getOrderList(@PathVariable("userid") String userId);

}

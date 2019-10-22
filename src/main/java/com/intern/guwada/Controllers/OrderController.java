package com.intern.guwada.Controllers;


import com.intern.guwada.Components.OrderWrapper;
import com.intern.guwada.Domain.Order;
import com.intern.guwada.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/personal/{id}")
    public ArrayList<Order> getOrderByCustomerId(@PathVariable String id){

        return orderService.getOrdersByCustomerId(id);


    }


    @GetMapping("/kitchenorder/{id}")
    public ArrayList<Order> getOrderByKitchen(@PathVariable  String id){

        return orderService.getOrdersByKitchenId(id);
    }
    @GetMapping("/get/{id}")
    public OrderWrapper getOrderById(@PathVariable  String id){

        return orderService.getOrderById(id);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){

            orderService.saveOrder(order);

        return  new Order();


    }
}

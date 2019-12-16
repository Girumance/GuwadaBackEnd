package com.intern.guwada.Controllers;


import com.intern.guwada.Components.CustomerOrder;
import com.intern.guwada.Components.OrderWrapper;
import com.intern.guwada.Constants.OrderStatus;
import com.intern.guwada.Domain.MealOrder;
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


    @GetMapping("/pending/{id}")
    public ArrayList<CustomerOrder> getPendingOrderByKitchen(@PathVariable  String id){

        return orderService.getOrdersByKitchenId(id, OrderStatus.Pending);
    }

    @GetMapping("/onprocessorder/{id}")
    public ArrayList<CustomerOrder> getOnprocessOrderByKitchen(@PathVariable  String id){

        return orderService.getOrdersByKitchenId(id, OrderStatus.OnProcess);
    }

    @GetMapping("/deliveredorder/{id}")
    public ArrayList<CustomerOrder> getDeliveredOrderByKitchen(@PathVariable  String id){

        return orderService.getOrdersByKitchenId(id, OrderStatus.Delivered);
    }



    @GetMapping("/get/{id}")
    public ArrayList<MealOrder> getOrderById(@PathVariable  String id){

        return orderService.getOrderById(id);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){

            orderService.saveOrder(order);

        return  new Order();


    }

    @GetMapping("/delete/{id}")
    public void DeleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);

    }

    @GetMapping("/makedelivered/{id}")
    public void makeItDelivered(@PathVariable String id){
        orderService.makeItDelivered(id);

    }


    @GetMapping("/makeonprocess/{id}")
    public void makeItOnProcess(@PathVariable String id){

        orderService.makeItOnProcess(id);
    }
}

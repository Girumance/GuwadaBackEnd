package com.intern.guwada.Services;


import com.intern.guwada.Domain.Order;
import com.intern.guwada.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public ArrayList<Order> getOrdersByKitchenId(String kitchenid){

        return orderRepository.getOrdersByKitchenId(kitchenid);
    }


    public ArrayList<Order> getOrdersByCustomerId(String customerId){


       return orderRepository.getOrdersByCustomerId(customerId);
    }



}

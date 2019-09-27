package com.intern.guwada.Repository;


import com.intern.guwada.Domain.Order;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface OrderRepository  extends MongoRepository<Order,String> {

    public ArrayList<Order> getOrdersByCustomerId(String id);
    public ArrayList<Order> getOrdersByKitchenId(String id);

}

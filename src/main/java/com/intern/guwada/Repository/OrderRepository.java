package com.intern.guwada.Repository;


import com.intern.guwada.Domain.Order;
import com.mongodb.Mongo;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface OrderRepository  extends MongoRepository<Order,String> {

    public ArrayList<Order> getOrdersByCustomerId(String id);

    //@Query(value = "{orderStatus: ?0}")
    public ArrayList<Order> getOrderByKitchenIdAndOrderStatus(String id,String status,Sort sort);






}

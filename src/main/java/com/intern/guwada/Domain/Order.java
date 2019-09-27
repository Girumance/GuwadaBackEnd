package com.intern.guwada.Domain;


import com.intern.guwada.Constants.OrderStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Document
@Data
public class Order {

    @GeneratedValue
    @Id
    private String id;
    private String customerId;
    private String kitchenId;
    private OrderStatus orderStatus;
    private ArrayList<MealOrder> mealorder;
    private String date=new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());



    public void setOrderStatus(String orderStatus){
        this.orderStatus=OrderStatus.valueOf(orderStatus);
    }

    public String getOrderStatus(){
        return orderStatus.toString();
    }


}

package com.intern.guwada.Components;

import com.intern.guwada.Constants.OrderStatus;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerOrder {
     private CustomerWrapper customer;
     private String orderId;
     private OrderStatus orderStatus;
     private String dateTime;


     public void setOrderStatus(String orderStatus){
          this.orderStatus=OrderStatus.valueOf(orderStatus);
     }

     public String getOrderStatus(){
          return  orderStatus.toString();
     }
}

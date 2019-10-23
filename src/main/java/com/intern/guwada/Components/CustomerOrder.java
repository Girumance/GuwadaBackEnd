package com.intern.guwada.Components;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerOrder {
     private CustomerWrapper customer;
     private String orderId;
     private String dateTime;
}

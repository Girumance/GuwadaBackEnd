package com.intern.guwada.Components;


import com.intern.guwada.Constants.OrderStatus;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class OrderWrapper {

   private CustomerWrapper customerWrapper;
   private ArrayList<MealOrderWrapper> mealOrderWrapper;
   private String orderStatus;
   private String date;
}

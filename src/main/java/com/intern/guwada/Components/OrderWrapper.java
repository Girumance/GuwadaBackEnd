package com.intern.guwada.Components;


import com.intern.guwada.Constants.OrderStatus;
import com.intern.guwada.Domain.MealOrder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class OrderWrapper {

   //private CustomerWrapper customerWrapper;
   private ArrayList<MealOrder> mealOrder;
  // private String orderStatus;
   //private String date;
}

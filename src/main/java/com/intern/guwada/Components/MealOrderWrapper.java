package com.intern.guwada.Components;

import com.intern.guwada.Domain.MealOrder;
import com.intern.guwada.Domain.Menu;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MealOrderWrapper {

    private MealOrder mealOrder;



}

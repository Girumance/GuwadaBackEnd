package com.intern.guwada.Components;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RatingWrapper {


    private String userId;
    private String kitchenId;
}


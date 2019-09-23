package com.intern.guwada.Domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Document
@Data
public class MealOrder {

    @GeneratedValue
    @Id
    private String id;
    private String quantitiy;
    private String menuId;
    private String additionalInformation;
    private ArrayList<String> with;






















}

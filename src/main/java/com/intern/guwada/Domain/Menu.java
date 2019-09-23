package com.intern.guwada.Domain;


import com.intern.guwada.Constants.MenuType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Data
public class Menu {

    private String id;
    private String title;
    private String description;
    private String price;
    private MenuType menuType;
    private String size;
    private ArrayList<String> ingredients;
    private ArrayList<String> with;
    private int rating;
}

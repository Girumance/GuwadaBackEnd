package com.intern.guwada.Domain;

import com.intern.guwada.Constants.Role;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;

@Document
@Data
public class Kitchen {

    @Id
    @GeneratedValue
    private String id;
    private Role role;
    private String title;
    private String descriptioin;
    private String ownerId;
    private String workignHours;
    private String rating;
    private boolean isOpen;
    private ArrayList<Menu> menu;


}

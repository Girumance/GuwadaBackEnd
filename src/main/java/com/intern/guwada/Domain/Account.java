package com.intern.guwada.Domain;

import com.intern.guwada.Constants.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;

@Component
@Document
@Data
public class Account{

    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    private Role role;

    private String blockNumber;
    private String roomNumber;

    private boolean isAccountBlocked=true;
    private boolean isAccountEnabled=true;


    public void setRole(String role){
        this.role=Role.valueOf(role);
    }

    public String getRole(){

        return String.valueOf(role);
    }


}

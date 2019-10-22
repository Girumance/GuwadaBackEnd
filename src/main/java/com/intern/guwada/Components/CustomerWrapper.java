package com.intern.guwada.Components;

import com.intern.guwada.Domain.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerWrapper {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String blockNumber;
    private String roomNumber;


    public void setAttributes(Account account){

        firstName=account.getFirstName();
        lastName=account.getLastName();
        email=account.getEmail();
        phoneNumber=account.getPhoneNumber();
        blockNumber=account.getBlockNumber();
        roomNumber=account.getRoomNumber();

    }
}

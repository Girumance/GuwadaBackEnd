package com.intern.guwada.Controllers;

import com.intern.guwada.Components.NewPassWrapper;
import com.intern.guwada.Domain.Account;
import com.intern.guwada.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;


    @PostMapping("/signup")
    public boolean createAccount(@RequestBody Account account){

         return  service.createAccount(account);

    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestBody NewPassWrapper newPassWrapper){

           return service.changePassword(newPassWrapper);
    }

    @PostMapping("/update")
    public Account updateAccount(@RequestBody Account account){

        return service.updateAccount(account);

    }

}

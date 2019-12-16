package com.intern.guwada.Services;


import com.intern.guwada.Components.NewPassWrapper;
import com.intern.guwada.Components.UserPrincipal;
import com.intern.guwada.Domain.Account;
import com.intern.guwada.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Account account = repository.findByEmail(email);

        return new UserPrincipal(account);

    }

    public boolean createAccount(Account account) {

        if (repository.findByEmail(account.getEmail()) != null)
            return false;

        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        return repository.save(account) != null ? true : false;


    }

    public Optional<Account> getAccountbyId(String id) {
        return repository.findById(id);
    }

    public Account getAccoutnByEmail(String email){

        return repository.findByEmail(email);
    }

    public int changePassword(NewPassWrapper newPassWrapper){

        Optional<Account> account=repository.findById(newPassWrapper.getOwnerId());

        String password=new BCryptPasswordEncoder().encode(newPassWrapper.getCurrentPassword());

        System.out.println(password);



        if(new BCryptPasswordEncoder().matches(account.get().getPassword(),password)){

            repository.delete(account.get());

            String newPass=new BCryptPasswordEncoder().encode(newPassWrapper.getNewPassword());
            account.get().setPassword(newPass);
            repository.save(account.get());

            return 1;

        }


        return  0;
    }


    public Account updateAccount(Account account){

        Optional<Account> old=repository.findById(account.getId());

        if(old.isPresent()){
            repository.delete(old.get());
            account.setPassword(old.get().getPassword());
            account.setRole(old.get().getRole());

            repository.save(account);
            return account;
        }
        return  old.get();

    }


}

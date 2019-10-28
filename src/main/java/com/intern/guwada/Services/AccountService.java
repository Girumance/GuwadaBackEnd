package com.intern.guwada.Services;


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

}

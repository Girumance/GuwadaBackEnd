package com.intern.guwada.Services;


import com.intern.guwada.Components.UserPrincipal;
import com.intern.guwada.Domain.Account;
import com.intern.guwada.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        return repository.save(account) != null ? true : false;


    }

}

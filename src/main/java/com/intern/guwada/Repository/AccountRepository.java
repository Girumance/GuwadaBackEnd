package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface AccountRepository extends MongoRepository<Account, String> {


    public Account findByEmail(String email);
}

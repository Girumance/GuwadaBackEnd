package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Account;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface AccountRepository extends MongoRepository<Account, String> {


    public Account findByEmail(String email);
}

package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Kitchen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface KitechenRepository extends MongoRepository<Kitchen,String> {

    @Query(value="{}",fields="{role:1,title:1,descriptioin:1,rating:1}")
    public ArrayList<Kitchen> findKitechenDetalils();

}

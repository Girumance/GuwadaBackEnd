package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Domain.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface KitechenRepository extends MongoRepository<Kitchen,String> {

    @Query(value="{}",fields="{role:1,title:1,descriptioin:1,rating:1}")
    public ArrayList<Kitchen> findKitechenDetalils();

    public Kitchen getByTitle(String title);

    @Query(value="{id:?0}")
    public Kitchen getByOwnerId(String id);


    @Query(value="{id:?0}",fields = "{menu:1,id:0}")
    public ArrayList<Kitchen> getMenuById(String id);



}

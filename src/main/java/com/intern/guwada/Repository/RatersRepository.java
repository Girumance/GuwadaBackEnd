package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Raters;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface RatersRepository extends MongoRepository<Raters,String> {

    public Raters findRatersByUserIdAndKitchenId(String userId,String kitchenid);

    public ArrayList<Raters> findRatersByKitchenId(String kitid);
}

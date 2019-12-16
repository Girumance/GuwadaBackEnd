package com.intern.guwada.Repository;

import com.intern.guwada.Domain.Likes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface LikesRepository extends MongoRepository<Likes, String> {

    @Query(value = "{menuId:?0,likeType:?1}",count = true)
    public long countLikesByMenuId(String menuId, String likeType);

    public Likes getLikesByMenuIdAndLikerId(String menuId,String likerId);


    public Likes findLikesByLikerIdAndMenuId(String likerid,String menuId);
}

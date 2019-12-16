package com.intern.guwada.Services;


import com.intern.guwada.Domain.Likes;
import com.intern.guwada.Repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LikeService {

    @Autowired
    LikesRepository likesRepository;

    public long coutLikesByMenuId(String menuId){

        return likesRepository.countLikesByMenuId(menuId, "Like");
    }

    public long countDislikesByMenuId(String menuId){
        return likesRepository.countLikesByMenuId(menuId, "Dislike");
    }

    public ArrayList<Long> saveLikes(Likes likes){

        Likes likes1=likesRepository.findLikesByLikerIdAndMenuId(likes.getLikerId(),likes.getMenuId());

        ArrayList<Long> likess=new ArrayList<>();
        if(likes1!=null){
            likesRepository.delete(likes1);
            likes.setId(likes1.getId());
            likesRepository.save(likes);
            long likesData=coutLikesByMenuId(likes.getMenuId());
            long DisLikes=countDislikesByMenuId(likes.getMenuId());

            likess.add(likesData);
            likess.add(DisLikes);
            return likess;

        }

        likesRepository.save(likes);
        long likesData=coutLikesByMenuId(likes.getMenuId());
        long DisLikes=countDislikesByMenuId(likes.getMenuId());

        likess.add(likesData);
        likess.add(DisLikes);
        return  likess;
    }

    public String getLikesByMenuIdandLikerId(String menuid,String likerId){

        Likes likes=likesRepository.getLikesByMenuIdAndLikerId(menuid,likerId);

        if(likes==null)return "";
        return  likes.getLikeType();
    }
}

package com.intern.guwada.Controllers;

import com.intern.guwada.Components.LikersWrapper;
import com.intern.guwada.Domain.Likes;
import com.intern.guwada.Services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/likes")
public class LikeController {


    @Autowired
   private LikeService likeService;

    @GetMapping("/likes/{id}")
    public long getLikesByMenuId(@PathVariable  String id){
        return likeService.coutLikesByMenuId(id);
    }
    @GetMapping("/dislikes/{id}")
    public long getDislikesByMenuId(@PathVariable String id){
        return likeService.countDislikesByMenuId(id);
    }

    @PostMapping("/save")
    public ArrayList<Long> saveLikes(@RequestBody Likes likes){



        return likeService.saveLikes(likes);
    }


    @PostMapping("/getLike")
    public String getLikesByOwnerId(@RequestBody LikersWrapper likersWrapper){

        return likeService.getLikesByMenuIdandLikerId(likersWrapper.getMenuId(),likersWrapper.getLikerId());
    }
}

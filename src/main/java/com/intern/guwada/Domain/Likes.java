package com.intern.guwada.Domain;

import com.intern.guwada.Constants.LikeType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document
@Data
public class Likes {
    @Id
    @GeneratedValue

    private String id;
    private  String likerId;
    private String menuId;
    private LikeType likeType;

    public void setLikeType(String likeType){
        this.likeType=LikeType.valueOf(likeType);

    }

    public String getLikeType(){
        return likeType.toString();
    }
}

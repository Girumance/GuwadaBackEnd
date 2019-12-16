package com.intern.guwada.Domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document
@Data
public class ImageStorage {

    @Id
    @GeneratedValue
    private String id;

    private String ownerId;

    private String fileName;
}

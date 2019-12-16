package com.intern.guwada.Domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document
public class Raters {

    @Id
    @GeneratedValue
    private String id;
    private String userId;
    private String kitchenId;
    private String value;
}

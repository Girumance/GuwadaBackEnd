package com.intern.guwada.Components;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikersWrapper {

    private String likerId;
    private String menuId;
}

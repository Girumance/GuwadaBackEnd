package com.intern.guwada.Components;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SearchWraper {
    private String search;
    private String title;
    private String id;
}

package com.example.juniortest.models.dto;

import com.example.juniortest.models.Color;
import lombok.Data;

@Data
public class ArticleDTO {
    private Long id;

    private String text;
    private Color color;

}

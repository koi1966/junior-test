package com.example.juniortest.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private int age;
//    private List<ArticleDTO> articleDto;
}

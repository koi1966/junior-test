package com.example.juniortest.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String status;
    private int age;

//    private List<ArticleDTO> articleDto;
}

package com.example.juniortest.models.dto;

import com.example.juniortest.models.Color;
import com.example.juniortest.models.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String text;
    private Color color;
    private UserDTO user;
}

package com.example.juniortest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private Color color;

//    private Long user_id;
    @ManyToOne(optional = false)
//    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
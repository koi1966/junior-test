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
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users users;

}
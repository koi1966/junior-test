package com.example.juniortest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
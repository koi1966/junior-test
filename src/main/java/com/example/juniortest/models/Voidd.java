package com.example.juniortest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Voidd {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private int age;

}

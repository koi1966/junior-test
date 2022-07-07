package com.example.juniortest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Article> articles;

    private String name;
    private int age;

//    @ManyToMany
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "roles_id"))
//    private List<Role> roles = new ArrayList<>();

}

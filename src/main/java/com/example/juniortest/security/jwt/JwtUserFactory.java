package com.example.juniortest.security.jwt;

import com.example.juniortest.models.Role;
import com.example.juniortest.models.Status;
import com.example.juniortest.models.UserJVT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(UserJVT user) {
        return new JwtUser(
                        user.getId(),
                        user.getUsername(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdate(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}

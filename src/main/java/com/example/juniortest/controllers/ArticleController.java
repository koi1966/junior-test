package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.dto.ArticleDTO;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j   // Логер
@RestController
public class ArticleController {
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @PostMapping("/article")
    public List<ArticleDTO> saveArticle(@RequestBody ArticleDTO articleDTO ) {


//        List<User> usr = userRepository.findAll();

        return null;
    }


}

package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.Article;
import com.example.juniortest.models.dto.ArticleDTO;
import com.example.juniortest.servise.AddArticle;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ArticleController {

    private AddArticle addArticle;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public ArticleController( AddArticle addArticle) {

        this.addArticle = addArticle;
    }

    @PostMapping(value = "/article")
    public ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = mapper.articleDtoToArticle(articleDTO);

        Article savedArt = addArticle.AddArticle(article);
        log.info("ArticleDto: {}, saved article: {}", articleDTO, savedArt);

        return mapper.articleToArticleDTO(savedArt);
    }
}


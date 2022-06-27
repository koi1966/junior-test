package com.example.juniortest.servise;

import com.example.juniortest.models.Article;
import com.example.juniortest.repo.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddArticle {

    private final ArticleRepository articleRepository;

    public AddArticle(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article AddArticle(Article article){

        log.info("User add: {} ", article);
        return articleRepository.save(article);
    }
}

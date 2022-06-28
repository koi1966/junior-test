package com.example.juniortest.servise;

import com.example.juniortest.models.Article;
import com.example.juniortest.models.User;
import com.example.juniortest.models.repo.ArticleRepository;
import com.example.juniortest.models.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AddArticle {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public AddArticle(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public Article AddArticle(Article article) {

        if (null == article.getUser().getId()) {
            throw new IllegalStateException("User id can not be empty!");
        }

        Optional<User> user = userRepository.findById(article.getUser().getId());
        if (user.isPresent()) {
            article.setUser(user.get());
            log.info("User add: {} ", article);
            return articleRepository.save(article);
        }
        throw new IllegalStateException("User id can not be empty!");

    }
}

package com.example.juniortest.models.repo;

import com.example.juniortest.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}

package com.example.juniortest.models.repo;

import com.example.juniortest.models.Article;
import com.example.juniortest.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {


}

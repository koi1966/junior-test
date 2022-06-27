package com.example.juniortest.mapper;

import com.example.juniortest.models.Article;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.ArticleDTO;
import com.example.juniortest.models.dto.UserDTO;

@org.mapstruct.Mapper
public interface Mapper {
    UserDTO userToUserDto(User user);
    User userDtoToUser(UserDTO userDto);
    ArticleDTO articleToArticleDTO(Article article);
    Article articleDtoToArticle(ArticleDTO articleDTO);


}

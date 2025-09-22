package com.sip.ams_rest.services;

import com.sip.ams_rest.entities.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> listArticles();
    Article getArticle(long id);
    Article saveArticle(long idProvider, Article article);
    void deleteArticle(long id);
    Optional<Article> findArticleById(long id);


}

package com.sip.ams_rest.controllers;

import com.sip.ams_rest.entities.Article;
import com.sip.ams_rest.entities.Provider;
import com.sip.ams_rest.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.listArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id) {
        return articleService.findArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/provider/{idProvider}")
    public ResponseEntity<Article> createArticle(@PathVariable long idProvider, @RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(idProvider, article);
        return ResponseEntity.ok(savedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public Article editArticle(@PathVariable long idProvider, @RequestBody Article article) {
        return this.articleService.saveArticle(idProvider, article);
    }

}
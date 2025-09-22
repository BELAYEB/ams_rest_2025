package com.sip.ams_rest.services;


import com.sip.ams_rest.entities.Article;
import com.sip.ams_rest.exceptions.ResourceNotFoundException;
import com.sip.ams_rest.repositories.ArticleRepository;
import com.sip.ams_rest.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ProviderRepository providerRepository;

    public ArticleServiceImp(ArticleRepository articleRepository,ProviderRepository providerRepository) {
        this.articleRepository = articleRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Article> listArticles() {
        // TODO Auto-generated method stub
        return (List<Article>)this.articleRepository.findAll();
    }

    @Override
    public Article getArticle(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    @Override
    public Article saveArticle(long idProvider, Article article) {
        return this.providerRepository.findById(idProvider).map(provider -> {
            article.setProvider(provider);
            return articleRepository.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + idProvider + " not found"));

    }

    @Override
    public void deleteArticle(long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Article not found with id " + id);
        }
        articleRepository.deleteById(id);

    }

    @Override
    public Optional<Article> findArticleById(long id) {
        // TODO Auto-generated method stub
        return articleRepository.findById(id);
    }


}

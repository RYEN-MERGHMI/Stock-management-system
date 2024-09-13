/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 08:19.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.controller;

import dev.rayen.Stock.Service.ArticleService;
import dev.rayen.Stock.controller.api.ArticleApi;
import dev.rayen.Stock.dto.ArticleDto;

import java.util.List;

public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}

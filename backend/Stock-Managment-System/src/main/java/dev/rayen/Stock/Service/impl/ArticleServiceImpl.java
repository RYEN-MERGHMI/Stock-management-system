/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 07:38.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.ArticleService;
import dev.rayen.Stock.dto.ArticleDto;
import dev.rayen.Stock.dto.CategoryDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.model.Article;
import dev.rayen.Stock.repository.ArticleRepository;
import dev.rayen.Stock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("Article is not valid ", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return articleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(articleDto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article Id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "no article found with id " + id + " in our database",
                        ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Article code is null");
            return null;
        }
        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "no article with code " + codeArticle + " in our database",
                                ErrorCodes.ARTICLE_NOT_FOUND
                        ));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Article Id is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}

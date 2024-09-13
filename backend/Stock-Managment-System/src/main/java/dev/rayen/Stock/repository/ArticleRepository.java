package dev.rayen.Stock.repository;

import dev.rayen.Stock.dto.ArticleDto;
import dev.rayen.Stock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository  extends JpaRepository<Article, Integer> {


    Optional<Article> findArticleByCodeArticle(String codeArticle);

    List<Article> findAllByCategoryId(Integer idCategory);
}

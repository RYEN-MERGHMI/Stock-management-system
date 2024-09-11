package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository  extends JpaRepository<Integer, Article> {


}

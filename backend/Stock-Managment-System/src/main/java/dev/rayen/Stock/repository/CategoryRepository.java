package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Category> {
}

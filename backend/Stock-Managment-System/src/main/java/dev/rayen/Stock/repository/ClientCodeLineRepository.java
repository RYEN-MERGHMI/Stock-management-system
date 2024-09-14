package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.ClientCodeLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCodeLineRepository extends JpaRepository<ClientCodeLine, Integer> {

    List<ClientCodeLine> findAllByOrderClientId(Integer id);

    List<ClientCodeLine> findAllByArticleId(Integer id);
}

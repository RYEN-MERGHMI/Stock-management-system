package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.ClientCodeLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCodeLineRepository extends JpaRepository<Integer,ClientCodeLine> {
}

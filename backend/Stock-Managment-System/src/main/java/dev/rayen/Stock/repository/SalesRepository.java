package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Integer, Sales> {
}

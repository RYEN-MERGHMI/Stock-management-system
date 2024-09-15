package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.SupplierCodeLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierCodeLineRepository extends JpaRepository< SupplierCodeLine, Integer> {
}

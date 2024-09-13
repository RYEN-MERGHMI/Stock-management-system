package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}

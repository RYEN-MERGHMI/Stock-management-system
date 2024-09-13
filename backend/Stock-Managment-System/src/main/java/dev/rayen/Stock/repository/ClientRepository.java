package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

/**
 * Made  by rayen.
 * Date: 11/09/2024.
 * Time: 09:04.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderClientRepository extends JpaRepository<OrderClient, Integer> {

    Optional<OrderClient> findOrderClientByCode(String code);

    List<OrderClient> findAllByClientId(Integer id);
}

/**
 * Made  by rayen.
 * Date: 13/09/2024.
 * Time: 08:37.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.OrderClient;
import dev.rayen.Stock.model.OrderSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderSupplierRepository extends JpaRepository<OrderSupplier, Integer> {
    Optional<OrderSupplier> findOrderSupplierByCode(String code);

    List<OrderClient> findAllBySupplierID(Integer id);
}

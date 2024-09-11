/**
 * Made  by rayen.
 * Date: 11/09/2024.
 * Time: 09:04.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderClientRepository extends JpaRepository<Integer, OrderClient> {
}

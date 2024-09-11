/**
 * Made  by rayen.
 * Date: 11/09/2024.
 * Time: 09:09.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.SaleLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleLineRepository extends JpaRepository<Integer, SaleLine> {
}

/**
 * Made  by rayen.
 * Date: 11/09/2024.
 * Time: 09:10.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.repository;

import dev.rayen.Stock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Integer, Roles> {
}

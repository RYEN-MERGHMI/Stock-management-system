/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:43.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto supplierDto);

    SupplierDto findById(Integer id);

    List<SupplierDto> findAll();

    void delete(Integer id);
}

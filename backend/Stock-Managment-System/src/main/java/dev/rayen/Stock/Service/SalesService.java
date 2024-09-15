/**
 * Made  by rayen.
 * Date: 15/09/2024.
 * Time: 10:17.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.SalesDto;

import java.util.List;

public interface SalesService {

    SalesDto save(SalesDto dto);

    SalesDto findById(Integer id);

    SalesDto findByCode(String code);

    List<SalesDto> findAll();

    void delete(Integer id);
}

/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:42.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}

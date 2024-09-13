/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:44.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.ClientService;
import dev.rayen.Stock.dto.ClientDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.exeption.InvalidOperationException;
import dev.rayen.Stock.model.OrderClient;
import dev.rayen.Stock.repository.ClientRepository;
import dev.rayen.Stock.repository.OrderClientRepository;
import dev.rayen.Stock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private OrderClientRepository orderClientRepository;

    public ClientServiceImpl(ClientRepository clientRepository, OrderClientRepository orderClientRepository) {
        this.clientRepository = clientRepository;
        this.orderClientRepository = orderClientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("this client is not valid", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "there is no client in this ID = " + id + "in the database",
                        ErrorCodes.CLIENT_NOT_FOUND)
                );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        List<OrderClient> commandeClients = orderClientRepository.findAllByClientId(id);
        if (!commandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete a client that already have an order Clients",
                    ErrorCodes.CLIENT_ALREADY_IN_USE);
        }
        clientRepository.deleteById(id);
    }



}

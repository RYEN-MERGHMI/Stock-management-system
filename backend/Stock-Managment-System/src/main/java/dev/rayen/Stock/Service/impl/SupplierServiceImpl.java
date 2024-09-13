/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:45.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.SupplierService;
import dev.rayen.Stock.dto.SupplierDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.exeption.InvalidOperationException;
import dev.rayen.Stock.model.OrderClient;
import dev.rayen.Stock.repository.OrderSupplierRepository;
import dev.rayen.Stock.repository.SupplierRepository;
import dev.rayen.Stock.validator.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;
    private OrderSupplierRepository orderSupplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository, OrderSupplierRepository orderSupplierRepository) {
        this.supplierRepository = supplierRepository;
        this.orderSupplierRepository = orderSupplierRepository;
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = SupplierValidator.validate(supplierDto);
        if (!errors.isEmpty()) {
           log.error("Supplier is not valid {}", supplierDto);
           throw new InvalidEntityException("Supplier is not valid",
                   ErrorCodes.SUPPLIER_NOT_VALID, errors);
        }
        return SupplierDto.fromEntity(
                supplierRepository.save(
                        supplierDto.toEntity(supplierDto)
                )
        );
    }

    @Override
    public SupplierDto findById(Integer id) {
        if (id == null) {
            log.error("Supplier ID is null");
            return null;
        }
        return supplierRepository.findById(id)
                .map(SupplierDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "no Supplier found with id  = " + id + " found in the database",
                        ErrorCodes.SUPPLIER_NOT_FOUND)
                );
    }

    @Override
    public List<SupplierDto> findAll() {
        return supplierRepository.findAll().stream()
                .map(SupplierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Supplier ID is null");
            return ;
        }
        List<OrderClient> orderSupplier = orderSupplierRepository.findAllBySupplierID(id);
        if(!orderSupplier.isEmpty()){
            throw new InvalidOperationException("Supplier is already in use can't be deleted",
                    ErrorCodes.SUPPLIER_ALREADY_IN_USE);
        }
        supplierRepository.deleteById(id);
    }
}

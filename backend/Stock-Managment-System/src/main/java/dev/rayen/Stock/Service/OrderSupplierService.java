package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.OrderSupplierDto;

public interface OrderSupplierService {

    OrderSupplierDto save(OrderSupplierDto orderSupplierDto);

    OrderSupplierDto findById(Integer id);

    OrderSupplierDto findAll();

    OrderSupplierDto delete(Integer id);
}

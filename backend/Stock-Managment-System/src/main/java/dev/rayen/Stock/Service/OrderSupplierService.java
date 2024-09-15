package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.OrderSupplierDto;

import java.util.List;

public interface OrderSupplierService {

    OrderSupplierDto save(OrderSupplierDto orderSupplierDto);

    OrderSupplierDto findById(Integer id);

    List<OrderSupplierDto> findAll();

    OrderSupplierDto delete(Integer id);
}

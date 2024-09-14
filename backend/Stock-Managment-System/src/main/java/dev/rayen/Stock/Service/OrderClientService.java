package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.ArticleDto;
import dev.rayen.Stock.dto.OrderClientDto;

import java.util.List;

public interface OrderClientService {

    OrderClientDto save(OrderClientDto orderClientDto);

    OrderClientDto findById(Integer id);

//    OrderClientDto findByCode(String code);

    List<OrderClientDto> findAll();

    void delete(Integer id);

}

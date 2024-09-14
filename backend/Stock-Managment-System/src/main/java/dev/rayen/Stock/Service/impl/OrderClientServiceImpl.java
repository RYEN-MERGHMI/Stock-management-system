/**
 * Made  by rayen.
 * Date: 14/09/2024.
 * Time: 08:17.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.OrderClientService;
import dev.rayen.Stock.dto.OrderClientDto;
import dev.rayen.Stock.repository.ArticleRepository;
import dev.rayen.Stock.repository.ClientRepository;
import dev.rayen.Stock.repository.OrderClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderClientServiceImpl implements OrderClientService {
    private OrderClientRepository orderClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public OrderClientServiceImpl(OrderClientRepository orderClientRepository,
                                  ClientRepository clientRepository,
                                  ArticleRepository articleRepository) {
        this.orderClientRepository = orderClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public OrderClientDto save(OrderClientDto orderClientDto) {
        return null;
    }

    @Override
    public OrderClientDto findById(Integer id) {
        return null;
    }

    @Override
    public OrderClientDto findByCode(String code) {
        return null;
    }

    @Override
    public List<OrderClientDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}

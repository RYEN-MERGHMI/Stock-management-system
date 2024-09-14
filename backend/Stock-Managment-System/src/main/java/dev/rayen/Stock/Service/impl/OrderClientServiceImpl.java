/**
 * Made  by rayen.
 * Date: 14/09/2024.
 * Time: 08:17.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.OrderClientService;
import dev.rayen.Stock.dto.ClientCodeLineDto;
import dev.rayen.Stock.dto.OrderClientDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.exeption.InvalidOperationException;
import dev.rayen.Stock.model.Article;
import dev.rayen.Stock.model.Client;
import dev.rayen.Stock.model.ClientCodeLine;
import dev.rayen.Stock.model.OrderClient;
import dev.rayen.Stock.repository.ArticleRepository;
import dev.rayen.Stock.repository.ClientCodeLineRepository;
import dev.rayen.Stock.repository.ClientRepository;
import dev.rayen.Stock.repository.OrderClientRepository;
import dev.rayen.Stock.validator.OrderClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderClientServiceImpl implements OrderClientService {
    private OrderClientRepository orderClientRepository;
    private ClientRepository clientRepository;
    private ClientCodeLineRepository clientCodeLineRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public OrderClientServiceImpl(OrderClientRepository orderClientRepository,
                                  ClientRepository clientRepository, ClientCodeLineRepository clientCodeLineRepository,
                                  ArticleRepository articleRepository) {
        this.orderClientRepository = orderClientRepository;
        this.clientRepository = clientRepository;
        this.clientCodeLineRepository = clientCodeLineRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public OrderClientDto save(OrderClientDto orderClientDto) {
        // validate order
        List<String> errors = OrderClientValidator.validate(orderClientDto);

        if (!errors.isEmpty()) {
            log.error("OrderClient is not valid");
            throw new InvalidEntityException("OrderClient is not valid", ErrorCodes.ORDER_CLIENT_NOT_VALID, errors);
        }

        // validate client existence
        Optional<Client> client = clientRepository.findById(orderClientDto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("client with id {} does not exist", orderClientDto.getClient().getId());
            throw new EntityNotFoundException("client not found with id " + orderClientDto.getClient().getId() + " in the database",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        // validate article existence
        List<String> articleErrors = new ArrayList<>();
        if (orderClientDto.getClientCodeLines() != null) {
            orderClientDto.getClientCodeLines().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("there is no article with id " + ligCmdClt.getArticle().getId() + " found in the database");
                    }
                }else {
                    articleErrors.add("can't add an order with article null");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("Some articles don't exist in the database");
            throw new InvalidEntityException("Some articles don't exist in the database", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        // Save the OrderClient entity
        OrderClient savedOrderClient = orderClientRepository.save(OrderClientDto.toEntity(orderClientDto));

        // Handle the ClientCodeLines
        if (orderClientDto.getClientCodeLines() != null) {
            orderClientDto.getClientCodeLines().forEach(ligCmdClt -> {
                // Convert the ClientCodeLineDto to a ClientCodeLine entity
                ClientCodeLine clientCodeLine = ClientCodeLineDto.toEntity(ligCmdClt);
                // Set the orderClient relationship
                clientCodeLine.setOrderClient(savedOrderClient);
                // Save the ClientCodeLine entity
                clientCodeLineRepository.save(clientCodeLine);
            });
        }

        return OrderClientDto.fromEntity(savedOrderClient);
    }


    @Override
    public OrderClientDto findById(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return null;
        }
        return orderClientRepository.findById(id)
                .map(OrderClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "there is not order found in the database with id {} " + id, ErrorCodes.ORDER_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public OrderClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("order client CODE is NULL");
            return null;
        }
        return orderClientRepository.findOrderClientByCode(code)
                .map(OrderClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "there is no order found in db with CODE " + code, ErrorCodes.ORDER_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<OrderClientDto> findAll() {
      return orderClientRepository.findAll().
              stream()
              .map(OrderClientDto::fromEntity)
              .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("Commande client ID is NULL");
            return;
        }
        List<ClientCodeLine> ligneCommandeClients = clientCodeLineRepository.findAllByOrderClientId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une commande client deja utilisee",
                    ErrorCodes.ORDER_CLIENT_ALREADY_IN_USE);
        }
        orderClientRepository.deleteById(id);
    }

}

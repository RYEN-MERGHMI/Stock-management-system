/**
 * Made  by rayen.
 * Date: 14/09/2024.
 * Time: 10:40.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.OrderSupplierService;
import dev.rayen.Stock.dto.OrderSupplierDto;
import dev.rayen.Stock.dto.SupplierCodeLineDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.exeption.InvalidOperationException;
import dev.rayen.Stock.model.Article;
import dev.rayen.Stock.model.OrderSupplier;
import dev.rayen.Stock.model.Supplier;
import dev.rayen.Stock.model.SupplierCodeLine;
import dev.rayen.Stock.repository.ArticleRepository;
import dev.rayen.Stock.repository.OrderSupplierRepository;
import dev.rayen.Stock.repository.SupplierCodeLineRepository;
import dev.rayen.Stock.repository.SupplierRepository;
import dev.rayen.Stock.validator.OrderSupplierValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderSupplierServiceImpl implements OrderSupplierService {
    private static final Logger log = LoggerFactory.getLogger(OrderSupplierServiceImpl.class);


    // todo ; implement the orderSupplierService

    private OrderSupplierRepository orderSupplierRepository;
    private SupplierCodeLineRepository supplierCodeLineRepository;
    private SupplierRepository supplierRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public OrderSupplierServiceImpl(OrderSupplierRepository orderSupplierRepository,
                                    SupplierCodeLineRepository supplierCodeLineRepository,
                                    SupplierRepository supplierRepository,
                                    ArticleRepository articleRepository) {
        this.orderSupplierRepository = orderSupplierRepository;
        this.supplierCodeLineRepository = supplierCodeLineRepository;
        this.supplierRepository = supplierRepository;
        this.articleRepository = articleRepository;
    }

    // todo check the orderClientServiceImpl class to reference
    @Override
    public OrderSupplierDto save(OrderSupplierDto orderSupplierDto) {

        List<String> errors = OrderSupplierValidator.validate(orderSupplierDto);

        if (!errors.isEmpty()) {
            log.error("order supplier is not valid");
            throw new InvalidEntityException("the order supplier is not valid", ErrorCodes.ORDER_SUPPLIER_NOT_VALID, errors);
        }
//
//        if(orderSupplierDto.getId() != null) {
//            throw new InvalidOperationException()
//        }
        Optional<Supplier> supplier = supplierRepository.findById(orderSupplierDto.getSupplier().getId());
        if(supplier.isEmpty()) {
            log.warn("Supplier with id {} was not found in the db", orderSupplierDto.getSupplier().getId());
            throw new EntityNotFoundException("not supplier with id {}" + orderSupplierDto.getSupplier().getId() + "found in the databasd",
                  ErrorCodes.ORDER_SUPPLIER_NOT_FOUND  );
        }
        List<String> articleErrors = new ArrayList<String>();

        if(orderSupplierDto.getSupplierCodeLines() != null) {
            orderSupplierDto.getSupplierCodeLines().forEach(linOrderSupp -> {
                if (linOrderSupp.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(linOrderSupp.getArticle().getId());
                    if(article.isEmpty()) {
                        articleErrors.add("article with id " + linOrderSupp.getArticle().getId() + " not found in the db");
                    }else {
                        articleErrors.add("impossible to save a null article");
                    }
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article doesn't exit in database", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        OrderSupplier savedOSupplier = orderSupplierRepository.save(orderSupplierDto.toEntity(orderSupplierDto));

        if (orderSupplierDto.getSupplierCodeLines() != null) {
            orderSupplierDto.getSupplierCodeLines().forEach(linOrderSupp -> {
                SupplierCodeLine supplierCodeLine = SupplierCodeLineDto.toEntity(linOrderSupp);
                supplierCodeLine.setOrderSuppliers(savedOSupplier);
                supplierCodeLineRepository.save(supplierCodeLine);
            });
        }
        return OrderSupplierDto.fromEntity(savedOSupplier);
    }

    @Override
    public OrderSupplierDto findById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return null;
        }
        return orderSupplierRepository.findById(id)
                .map(OrderSupplierDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "there is no supplier found with id  " + id, ErrorCodes.ORDER_SUPPLIER_NOT_FOUND
                ));
    }


    @Override
    public List<OrderSupplierDto> findAll() {
       return  orderSupplierRepository.findAll().stream()
               .map(OrderSupplierDto::fromEntity)
               .collect(Collectors.toList());
    }

    @Override
    public OrderSupplierDto delete(Integer id) {
        return null;
    }
}




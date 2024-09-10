/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:19.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.SupplierCodeLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SupplierCodeLineDto {

    private Integer id;

    private ArticleDto article;


    private OrderSupplierDto orderSuppliers;


    private BigDecimal quantity;


    private BigDecimal prixUnitaire;

    private Integer idCompany;

    public static SupplierCodeLineDto fromEntity(SupplierCodeLine supplierCodeLine){


        if(supplierCodeLine == null){
            return null;
        }
        return SupplierCodeLineDto.builder()
                .id(supplierCodeLine.getId())
                .article(ArticleDto.fromEntity(supplierCodeLine.getArticle()))
                .orderSuppliers(OrderSupplierDto.fromEntity(supplierCodeLine.getOrderSuppliers()))
                .quantity(supplierCodeLine.getQuantity())
                .prixUnitaire(supplierCodeLine.getPrixUnitaire())
                .idCompany(supplierCodeLine.getIdCompany())
                .build();

    }

    public static SupplierCodeLine toEntity(SupplierCodeLineDto supplierCodeLineDto){
        if(supplierCodeLineDto == null){
            return null;
        }
       SupplierCodeLine supplierCodeLine = new SupplierCodeLine();
        supplierCodeLine.setId(supplierCodeLineDto.getId());
        supplierCodeLine.setArticle(ArticleDto.toEntity(supplierCodeLineDto.getArticle()));
        supplierCodeLine.setPrixUnitaire(supplierCodeLineDto.getPrixUnitaire());
        supplierCodeLine.setQuantity(supplierCodeLineDto.getQuantity());
        supplierCodeLine.setIdCompany(supplierCodeLineDto.getIdCompany());
        return supplierCodeLine;
    }

}




































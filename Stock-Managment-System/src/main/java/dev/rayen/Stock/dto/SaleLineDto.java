/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:18.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.SaleLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaleLineDto {

    private Integer id;

    private SalesDto sales;


    private BigDecimal quantity;


    private ArticleDto article;

    private Integer idCompany;

    private BigDecimal prixUnitaire;

    public static SaleLineDto fromEntity(SaleLine saleLine){
        if(saleLine == null){
            return null;
        }
        return SaleLineDto.builder()
                .id(saleLine.getId())
                .quantity(saleLine.getQuantity())
                .prixUnitaire(saleLine.getPrixUnitaire())
                .article(ArticleDto.fromEntity(saleLine.getArticle()))
                .sales(SalesDto.fromEntity(saleLine.getSales()))
                .build();
    }

    public static SaleLine toEntity(SaleLineDto saleLineDto){
        if (saleLineDto == null)
            return null;

        SaleLine saleLine = new SaleLine();
        saleLine.setId(saleLineDto.getId());
        saleLine.setQuantity(saleLineDto.getQuantity());
        saleLine.setPrixUnitaire(saleLineDto.getPrixUnitaire());
        saleLine.setArticle(ArticleDto.toEntity(saleLineDto.getArticle()));
        saleLine.setSales(SalesDto.toEntity(saleLineDto.getSales()));
        return saleLine;

    }

}

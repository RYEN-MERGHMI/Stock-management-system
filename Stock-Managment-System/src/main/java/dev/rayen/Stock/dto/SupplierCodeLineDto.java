/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:19.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

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

}




































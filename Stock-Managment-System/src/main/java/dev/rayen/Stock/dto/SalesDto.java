/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:18.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.SaleLine;
import dev.rayen.Stock.model.Sales;
import lombok.Builder;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SalesDto {

    private Integer id;


    private String code;

    private Integer idCompany;

    private List<SaleLineDto> salesLine;

    private Instant dateSale;

    private String comment;

    public static SalesDto fromEntity(Sales sales){
        if (sales == null){
            return null;
        }
        return SalesDto.builder()
                .id(sales.getId())
                .code(sales.getCode())
                .idCompany(sales.getIdCompany())
                .comment(sales.getComment())
                .build();
    }

    public static Sales toEntity(SalesDto salesDto){
        if(salesDto == null){
            return null;
        }
        Sales sales = new Sales();
        sales.setId(salesDto.getId());
        sales.setCode(salesDto.getCode());
        sales.setIdCompany(salesDto.getIdCompany());
        sales.setComment(salesDto.getComment());
        return sales;
    }
}

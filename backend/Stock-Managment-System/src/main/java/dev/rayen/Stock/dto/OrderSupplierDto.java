/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:18.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.OrderStatus;
import dev.rayen.Stock.model.OrderSupplier;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class OrderSupplierDto {

    private Integer id;

    private String code;

    private Instant OrderDate;

    private Integer idCompany;

    private OrderStatus orderStatus;

    private SupplierDto supplier;

    private List<SupplierCodeLineDto> supplierCodeLines;

    public static OrderSupplierDto fromEntity(OrderSupplier orderSupplier){
        if(orderSupplier == null){
            return null;
        }
        return OrderSupplierDto.builder()
                .id(orderSupplier.getId())
                .code(orderSupplier.getCode())
                .OrderDate(orderSupplier.getOrderDate())
                .idCompany(orderSupplier.getIdCompany())
                .orderStatus(orderSupplier.getOrderStatus())
                .supplier(SupplierDto.fromEntity(orderSupplier.getSupplier()))
                .build();
    }

    public static OrderSupplier toEntity(OrderSupplierDto orderSupplierDto){
        if(orderSupplierDto == null){
            return null;
        }

        OrderSupplier orderSupplier = new OrderSupplier();
        orderSupplier.setId(orderSupplierDto.getId());
        orderSupplier.setCode(orderSupplierDto.getCode());
        orderSupplier.setOrderDate(orderSupplierDto.getOrderDate());
        orderSupplier.setIdCompany(orderSupplierDto.getIdCompany());
        orderSupplier.setOrderStatus(orderSupplierDto.getOrderStatus());

        return orderSupplier;
    }

}

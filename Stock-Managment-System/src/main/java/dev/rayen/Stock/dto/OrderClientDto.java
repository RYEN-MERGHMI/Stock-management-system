/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:17.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.OrderClient;
import dev.rayen.Stock.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class OrderClientDto {

    private Integer id;

    private String code;

    private Instant orderDate;

    private ClientDto client;

    private OrderStatus orderStatus;

    private Integer idCompany;

    private List<ClientCodeLineDto> clientCodeLines;

    public static OrderClientDto fromEntity(OrderClient orderClient){
        if (orderClient == null){
            return null;
        }
        return OrderClientDto.builder()
                .id(orderClient.getId())
                .code(orderClient.getCode())
                .orderDate(orderClient.getOrderDate())
                .orderStatus(orderClient.getOrderStatus())
                .client(ClientDto.fromEntity(orderClient.getClient()))
                .idCompany(orderClient.getIdCompany())
                .build();
    }

    public static OrderClient toEntity(OrderClientDto orderClientDto) {
        if(orderClientDto == null) return null;

        OrderClient orderClient = new OrderClient();
        orderClient.setId(orderClientDto.getId());
        orderClient.setCode(orderClientDto.getCode());
        orderClient.setOrderDate(orderClientDto.getOrderDate());
        orderClient.setOrderStatus(orderClientDto.getOrderStatus());
        orderClient.setClient(ClientDto.toEntity(orderClientDto.getClient()));
        orderClient.setIdCompany(orderClientDto.getIdCompany());
        return orderClient;
    }

    /*
        public boolean isOrderDelivered(){
            return OrderStatus.DELIVERED.equals(this.orderStatus);
        }
    */
}

/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:16.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rayen.Stock.model.ClientCodeLine;
import dev.rayen.Stock.model.OrderClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ClientCodeLineDto {

    private Integer id;

    private ArticleDto article;

    @JsonIgnore
    private OrderClientDto orderClient;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    private Integer idCompany;

    private static ClientCodeLineDto fromEntity(ClientCodeLine clientCodeLine) {
        if(clientCodeLine == null) return null;
        // todo handle exception

        return ClientCodeLineDto.builder()
                .id(clientCodeLine.getId())
                .article(ArticleDto.fromEntity(clientCodeLine.getArticle()))
                .quantity(clientCodeLine.getQuantity())
                .prixUnitaire(clientCodeLine.getPrixUnitaire())
                .idCompany(clientCodeLine.getIdCompany())
                .build();
    }

    private static ClientCodeLine toEntity(ClientCodeLineDto clientCodeLineDto) {
        if(clientCodeLineDto == null) return null;
        // todo handle exception

        ClientCodeLine clientCodeLine = new ClientCodeLine();
        clientCodeLine.setId(clientCodeLineDto.getId());
        clientCodeLine.setArticle(ArticleDto.toEntity(clientCodeLineDto.getArticle()));
        clientCodeLine.setQuantity(clientCodeLineDto.getQuantity());
        clientCodeLine.setPrixUnitaire(clientCodeLineDto.getPrixUnitaire());
        clientCodeLine.setIdCompany(clientCodeLineDto.getIdCompany());
        return clientCodeLine;
    }
}

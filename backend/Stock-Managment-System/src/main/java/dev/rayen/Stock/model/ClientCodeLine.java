/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:40.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ClientCodeLine")
public class ClientCodeLine  extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idOrderClient")
    private OrderClient orderClient;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "idCompany")
    private Integer idCompany;
}

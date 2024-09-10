/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:38.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import dev.rayen.Stock.dto.ArticleDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SaleLine")
public class SaleLine extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idsale")
    private Sales sales;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;



    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "idCompany")
    private Integer idCompany;
}

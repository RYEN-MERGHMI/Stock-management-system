/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:37.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

// Stock movement
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StockMovement")
public class StckMvmnt extends AbstractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "typeMvt")
    private  TypeMvtStk typeMvt;

    @Column(name = "idCompany")
    private Integer idCompany;


    @Column(name = "sourceStckMvmnt")
    @Enumerated(EnumType.STRING)
    private SourceStckMvmnt sourceStckMvmnt;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
}

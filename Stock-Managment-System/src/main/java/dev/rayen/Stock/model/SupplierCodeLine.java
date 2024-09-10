/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:38.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SupplierCodeLine")
public class SupplierCodeLine extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idordersupplier")
    private OrderSupplier orderSuppliers;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

}

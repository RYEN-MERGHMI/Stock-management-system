/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:39.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderSupplier")
public class OrderSupplier extends AbstractEntity {


    @Column(name = "code")
    private String code;

    @Column(name = "orderData")
    private Instant OrderDate;

    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "idsupplier")
    private Supplier supplier;

    @Column(name = "idCompany")
    private Integer idCompany;

    @OneToMany(mappedBy = "orderSuppliers")
    private List<SupplierCodeLine> supplierCodeLines;

}

/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:40.
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
@Table(name = "OrderClient")
public class OrderClient extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "orderDate")
    private Instant orderDate;


    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

    @Column(name = "idCompany")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @OneToMany(mappedBy = "orderClient")
    private List<ClientCodeLine> clientCodeLines;
}

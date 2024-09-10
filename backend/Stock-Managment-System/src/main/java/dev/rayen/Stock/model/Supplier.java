/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:39.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "idCompany")
    private Integer idCompany;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    private List<OrderSupplier> orderSuppliers;
}

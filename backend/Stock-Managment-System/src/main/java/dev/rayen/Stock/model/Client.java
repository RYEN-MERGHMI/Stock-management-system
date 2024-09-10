/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:40.
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
@Table(name = "Client")
public class Client extends AbstractEntity{

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

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "idCompany")
    private Integer idCompany;

    @OneToMany(mappedBy = "client")
    private List<OrderClient> orderClients;
}

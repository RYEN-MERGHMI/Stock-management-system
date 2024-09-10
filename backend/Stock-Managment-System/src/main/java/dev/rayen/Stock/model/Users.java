/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:36.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class Users extends AbstractEntity{



    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Instant birthDate;

    @Column(name = "password")
    private String password;

    @Embedded
    private Address address;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idCompany")
    private Company company;


    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<Roles> roles;
}

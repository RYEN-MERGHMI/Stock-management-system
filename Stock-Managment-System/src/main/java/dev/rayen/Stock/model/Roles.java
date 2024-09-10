/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:43.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Roles extends AbstractEntity{

    @Column(name = "roleName")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "isUser")
    private Users users;
}

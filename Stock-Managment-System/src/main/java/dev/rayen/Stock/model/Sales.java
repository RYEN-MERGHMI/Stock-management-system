/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:38.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sales")
public class Sales extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "dateSale")
    private Instant dateSale;

    @Column(name = "idCompany")
    private Integer idCompany;

    @Column(name ="comment")
    private String comment;
}

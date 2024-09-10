/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 10:14.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address  {

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "ville")
    private String ville;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;
}

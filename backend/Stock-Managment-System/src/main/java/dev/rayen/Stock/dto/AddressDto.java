/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:27.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private Integer id;

    private String address1;

    private String address2;

    private String ville;

    private String postalCode;

    private String country;

    public static AddressDto fromEntity(Address address) {
        if(address == null)
            return null;
        // TODO handle the exception

        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .country(address.getCountry())
                .ville(address.getVille())
                .postalCode(address.getPostalCode())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {
        if(addressDto == null)
            return null;
        // TODO handle the exception

        Address address = new Address();
        addressDto.setAddress1(addressDto.getAddress1());
        addressDto.setAddress2(addressDto.getAddress2());
        addressDto.setCountry(addressDto.getCountry());
        addressDto.setVille(addressDto.getVille());
        addressDto.setPostalCode(addressDto.getPostalCode());

        return address ;
    }
}

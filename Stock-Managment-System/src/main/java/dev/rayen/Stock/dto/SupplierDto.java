/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:19.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rayen.Stock.model.Supplier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SupplierDto {
    private Integer id;

    private String name;


    private AddressDto address;

    private String lastName;


    private String photo;

    private Integer idCompany;

    private String email;

    private String phoneNumber;

    @JsonIgnore
    private List<OrderSupplierDto> orderSuppliers;

    private static SupplierDto fromEntity(Supplier supplier){
        if(supplier == null){
            return null;
        }
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(AddressDto.fromEntity(supplier.getAddress()))
                .lastName(supplier.getLastName())
                .photo(supplier.getPhoto())
                .email(supplier.getEmail())
                .phoneNumber(supplier.getPhoneNumber())
                .idCompany(supplier.getIdCompany())
                .build();
    }

    private static Supplier toEntity(SupplierDto supplierDto){

        if (supplierDto == null){
            return null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setName(supplierDto.getName());
        supplier.setAddress(AddressDto.toEntity(supplierDto.getAddress()));
        supplier.setLastName(supplierDto.getLastName());
        supplier.setPhoto(supplierDto.getPhoto());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setIdCompany(supplierDto.getIdCompany());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());

        return supplier;
    }


}

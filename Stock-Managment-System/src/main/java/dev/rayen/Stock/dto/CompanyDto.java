/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:16.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rayen.Stock.model.Company;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyDto {

    private Integer id;

    private String name;

    private String description;

    private AddressDto address;

    private String codeFiscal;

    private String photo;

    private String email;

    private String phoneNumber;

    private String steWeb;

    @JsonIgnore
    private List<UsersDto> users;

    public static CompanyDto fromEntity(Company company) {
        if(company == null) return null;
        // todo implement exception

        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .address(AddressDto.fromEntity(company.getAddress()))
                .codeFiscal(company.getCodeFiscal())
                .photo(company.getPhoto())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .steWeb(company.getSteWeb())
                .build();
    }

    public static Company toEntity(CompanyDto companyDto){
        if(companyDto == null) return null;
        // todo implement exception

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        company.setAddress(AddressDto.toEntity(companyDto.getAddress()));
        company.setCodeFiscal(companyDto.getCodeFiscal());
        company.setPhoto(companyDto.getPhoto());
        company.setEmail(companyDto.getEmail());
        company.setPhoneNumber(companyDto.getPhoneNumber());
        company.setSteWeb(companyDto.getSteWeb());

        return company;
    }
}























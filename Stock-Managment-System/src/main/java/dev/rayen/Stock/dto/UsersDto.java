/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:20.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.Users;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UsersDto {


    private Integer id;


    private String name;

    private String lastName;


    private String email;

    private Instant birthDate;


    private String password;


    private AddressDto address;


    private String photo;

    private CompanyDto company;


    private List<RolesDto> roles;

    public static UsersDto fromEntity(Users users) {
        if (users == null) return null;
        return UsersDto.builder()
                .id(users.getId())
                .name(users.getName())
                .lastName(users.getLastName())
                .email(users.getEmail())
                .password(users.getPassword())
                .birthDate(users.getBirthDate())
                .address(AddressDto.fromEntity(users.getAddress()))
                .photo(users.getPhoto())
                .company(CompanyDto.fromEntity(users.getCompany()))
                .roles(
                        users.getRoles() != null ?
                                users.getRoles().stream().map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();

    }


    public static Users toEntity(UsersDto usersDto) {
        if (usersDto == null) return null;
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLastName(usersDto.getLastName());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setBirthDate(usersDto.getBirthDate());
        users.setAddress(AddressDto.toEntity(usersDto.getAddress()));
        users.setPhoto(usersDto.getPhoto());
        users.setCompany(CompanyDto.toEntity(usersDto.getCompany()));

        return users;
    }
}































/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:16.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rayen.Stock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String name;

    private AddressDto address;

    private String lastName;

    private String photo;

    private String email;

    private String phoneNumber;

    private Integer idCompany;

    @JsonIgnore
    private List<OrderClientDto> orderClients;

    public static ClientDto fromEntity(Client client){
        if(client == null) return null;
        // todo handle exception

        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .address(AddressDto.fromEntity(client.getAddress()))
                .lastName(client.getLastName())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .idCompany(client.getIdCompany())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if(clientDto == null) return null;
        // todo handle exception

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setAddress(AddressDto.toEntity(clientDto.getAddress()));
        client.setLastName(clientDto.getLastName());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setIdCompany(clientDto.getIdCompany());

        return client;

    }
}

/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:18.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rayen.Stock.model.Roles;
import dev.rayen.Stock.model.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String roleName;

    @JsonIgnore
    private Users user;

    public static RolesDto fromEntity(Roles role) {
        if(role == null) return null;
        return RolesDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .build();
    }

    public static  Roles toEntity(RolesDto rolesDto){
        if(rolesDto == null) return null;
        Roles role = new Roles();
        role.setId(rolesDto.getId());
        role.setRoleName(rolesDto.getRoleName());
        return role;
    }
}

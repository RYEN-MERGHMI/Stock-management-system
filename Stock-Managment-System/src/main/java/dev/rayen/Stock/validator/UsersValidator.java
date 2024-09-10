/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 09:51.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.UsersDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UsersValidator {

    public static List<String> validate(UsersDto usersDto) {
        List<String> errors = new ArrayList<>();

        if (usersDto == null) {
            errors.add("reenter the username");
            errors.add("reenter the  lastname");
            errors.add("reenter the user password");
            errors.add("reenter the user address ");
            return errors;
        }
        if(!StringUtils.hasLength(usersDto.getName())){
            errors.add("reenter the username");
        }

        if(!StringUtils.hasLength(usersDto.getLastName())){
            errors.add("reenter the lastname");
        }
        if(!StringUtils.hasLength(usersDto.getEmail())){
            errors.add("reenter the user email");
        }
        if(!StringUtils.hasLength(usersDto.getPassword())){
            errors.add("reenter the user password");
        }
        if(usersDto.getBirthDate() == null){
            errors.add("reenter the user birth date");
        }

        if(usersDto.getAddress() == null){
            errors.add("reenter the user address ");
        }else {
            if (!StringUtils.hasLength(usersDto.getAddress().getAddress1())) {
                errors.add("the address1 field is obligatory ");
            }
            if(!StringUtils.hasLength(usersDto.getAddress().getVille())){
                errors.add("the ville field is obligatory ");
            }
            if(!StringUtils.hasLength(usersDto.getAddress().getPostalCode())){
                errors.add("the postal code field  is obligatory ");
            }
            if(!StringUtils.hasLength(usersDto.getAddress().getCountry())){
                errors.add("the country field  is obligatory ");
            }
        }
        return errors;

    }
}

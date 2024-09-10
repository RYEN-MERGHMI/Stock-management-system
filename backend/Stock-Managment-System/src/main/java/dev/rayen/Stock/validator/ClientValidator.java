/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 10:24.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.ClientDto;
import dev.rayen.Stock.dto.UsersDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();
        if(clientDto == null){
            errors.add("reenter the client name");
            errors.add("reenter the client last name");
            errors.add("reenter the client email");
            errors.add("reenter the client phone number");
            return errors;
        }
        if(!StringUtils.hasLength(clientDto.getName())){
            errors.add("reenter the client");
        }
        if(!StringUtils.hasLength(clientDto.getLastName())){
            errors.add("reenter the client last name");
        }
        if(!StringUtils.hasLength(clientDto.getEmail())){
            errors.add("reenter the client email");
        }
        if(!StringUtils.hasLength(clientDto.getPhoneNumber())){
            errors.add("reenter the client phone number");
        }
        return errors;
    }
}

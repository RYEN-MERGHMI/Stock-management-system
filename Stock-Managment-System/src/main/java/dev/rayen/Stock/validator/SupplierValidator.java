/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 10:40.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.SupplierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDto supplierDto) {
        List<String> errors = new ArrayList<>();
        if(supplierDto == null){
            errors.add("reenter the Supplier name");
            errors.add("reenter the Supplier last name");
            errors.add("reenter the Supplier email");
            errors.add("reenter the Supplier phone number");
            return errors;
        }
        if(!StringUtils.hasLength(supplierDto.getName())){
            errors.add("reenter the Supplier");
        }
        if(!StringUtils.hasLength(supplierDto.getLastName())){
            errors.add("reenter the Supplier last name");
        }
        if(!StringUtils.hasLength(supplierDto.getEmail())){
            errors.add("reenter the Supplier email");
        }
        if(!StringUtils.hasLength(supplierDto.getPhoneNumber())){
            errors.add("reenter the Supplier phone number");
        }
        return errors;
    }
}

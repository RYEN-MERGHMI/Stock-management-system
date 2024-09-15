/**
 * Made  by rayen.
 * Date: 15/09/2024.
 * Time: 08:42.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.OrderSupplierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderSupplierValidator {

    public static List<String> validate(OrderSupplierDto orderSupplierDto){
        List<String> errors = new ArrayList<>();

        if (orderSupplierDto == null){
            errors.add("reenter the code of the order");
            errors.add("reenter the date of the order");
            errors.add("reenter the state of the order");
            errors.add("reenter the client");
            return errors;
        }
        if (!StringUtils.hasLength(orderSupplierDto.getCode())) {
            errors.add("reenter the code of the order");
        }
        if(orderSupplierDto.getOrderDate() == null) {
            errors.add("reenter the date of the order");
        }
        if(orderSupplierDto.getOrderStatus() == null) {
            errors.add("reenter the state of the order");
        }
        if( orderSupplierDto.getSupplier() == null  || orderSupplierDto.getSupplier().getId() == null) {
            errors.add("reenter the Supplier");
        }

        return errors;
        }
    }

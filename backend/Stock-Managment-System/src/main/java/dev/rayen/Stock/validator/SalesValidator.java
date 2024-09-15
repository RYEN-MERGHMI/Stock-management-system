/**
 * Made  by rayen.
 * Date: 15/09/2024.
 * Time: 10:21.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.SalesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SalesValidator {

    public static List<String> validate(SalesDto salesDto) {
        List<String> errors = new ArrayList<>();
        if (salesDto == null) {
            errors.add("reenter the code of the order");
            errors.add("reenter the date of the order");
            return errors;
        }

        if (!StringUtils.hasLength(salesDto.getCode())) {
            errors.add("reenter the code of the order");
        }
        if (salesDto.getDateSale() == null) {
            errors.add("reenter the date of the order");
        }

        return errors;
    }
}

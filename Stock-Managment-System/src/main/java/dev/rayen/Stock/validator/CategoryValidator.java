/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 09:37.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("reinsert the category code");
        }
        return errors;
    }

}

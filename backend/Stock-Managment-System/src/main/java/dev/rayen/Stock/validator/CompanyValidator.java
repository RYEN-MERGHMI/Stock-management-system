/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 10:46.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.CompanyDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {

    public static List<String> validate(CompanyDto companyDto) {
        List<String> errors = new ArrayList<>();
        if(companyDto == null){
            errors.add("reenter the name of the company");
            errors.add("reenter the description of the company");
            errors.add("reenter the fiscal code of the company");
            errors.add("reenter email of the company");
            errors.add("reenter phone number of the company");
            return errors;
        }
        if (!StringUtils.hasLength(companyDto.getName())) {
            errors.add("reenter the name of the company");
        }
        if (!StringUtils.hasLength(companyDto.getCodeFiscal())) {
            errors.add("reenter the fiscal code of th company");
        }
    }
}
// TODO :
// TOD      CMPLETE THE COMPANY VALIDATOR ** COMPLETE THE COMPANY SERVICE IMPLIMENTATION
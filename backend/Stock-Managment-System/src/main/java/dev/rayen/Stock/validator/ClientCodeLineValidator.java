/**
 * Made  by rayen.
 * Date: 14/09/2024.
 * Time: 08:56.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.ClientCodeLineDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientCodeLineValidator {

    public static List<String> validate(ClientCodeLineDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("The ClientCodeLineDto object is null.");
            errors.add("Reenter the article for the client code line");
            errors.add("Reenter a valid quantity");
            errors.add("Reenter a valid unit price");
            return errors;
        }
        if (dto.getArticle() == null || dto.getArticle().getId() == null) {
            errors.add("Reenter the article for the client code line");
        }
        if (dto.getQuantity() == null || dto.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
            errors.add("Reenter a valid quantity");
        }
        if (dto.getPrixUnitaire() == null || dto.getPrixUnitaire().compareTo(BigDecimal.ZERO) <= 0) {
            errors.add("Reenter a valid unit price");
        }
        return errors;
    }
}

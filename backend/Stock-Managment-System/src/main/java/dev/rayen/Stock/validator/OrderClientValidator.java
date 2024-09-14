/**
 * Made  by rayen.
 * Date: 14/09/2024.
 * Time: 08:25.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.OrderClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderClientValidator {

    public static List<String> validate(OrderClientDto orderClient) {
        List<String> errors = new ArrayList<>();

        if (orderClient == null) {
            errors.add("reenter the code of the order");
            errors.add("reenter the date of the order");
            errors.add("reenter the status of the order");
            errors.add("reenter the Client");
            return errors;
        }
        if (!StringUtils.hasLength(orderClient.getCode())) {
            errors.add("reenter the code of the order");
        }
        if( orderClient.getOrderDate() != null ) {
            errors.add("reenter the date of the order");
        }
        if (!StringUtils.hasLength(orderClient.getOrderStatus().toString())) {
            errors.add("reenter the status of the order");
        }
        if (orderClient.getClient() == null || orderClient.getClient().getId() == null) {
            errors.add("reenter the Client");
        }

        return errors;
    }

}

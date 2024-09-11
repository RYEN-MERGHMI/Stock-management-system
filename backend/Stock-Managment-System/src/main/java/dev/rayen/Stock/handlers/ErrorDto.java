/**
 * Made  by rayen.
 * Date: 11/09/2024.
 * Time: 09:44.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.handlers;

import dev.rayen.Stock.exeption.ErrorCodes;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;

    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();
}

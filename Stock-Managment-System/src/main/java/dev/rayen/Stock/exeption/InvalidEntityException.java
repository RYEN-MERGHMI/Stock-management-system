/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 11:05.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.exeption;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;

    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

}

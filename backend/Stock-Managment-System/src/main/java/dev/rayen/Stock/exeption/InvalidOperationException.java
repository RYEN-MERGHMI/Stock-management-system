/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 10:27.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.exeption;

import lombok.Getter;

public class InvalidOperationException extends  RuntimeException{

    @Getter
    private ErrorCodes errorCode;

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperationException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidOperationException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

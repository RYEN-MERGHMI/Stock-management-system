/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 10:58.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.exeption;

import lombok.Getter;

public class EntityNotFoundException extends  RuntimeException {

    @Getter
    private ErrorCodes errorCodes ;

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message , Throwable cause){
        super(message , cause);
    }
     public EntityNotFoundException(String mes , Throwable cause , ErrorCodes errorCodes){
        super(mes , cause);
        this.errorCodes = errorCodes ;
     }

     public EntityNotFoundException(String message ,  ErrorCodes error){
        super(message);
        this.errorCodes = error ;
     }
}

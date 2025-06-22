package ApiProject.RestaurantReservation.exceptions;

import ApiProject.RestaurantReservation.dto.error_response.Error_Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: A global exception handler to return customized json error messages when
 * exceptions are throw
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataConflitException.class)
    public static ResponseEntity<Error_Response> errorResponse(DataConflitException ex) {

        Error_Response error = new Error_Response("Bad Request",
                                                  ex.getMessage(),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<Error_Response> reservationNotFoundError(DataNotFound ex){

        Error_Response error = new Error_Response("Not Found",
                                                  ex.getMessage(), HttpStatus.NOT_FOUND
                                                                             .value());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationTimeException.class)
    public ResponseEntity<Error_Response> reservationTimeError(ReservationTimeException ex){

        Error_Response error = new Error_Response("Bad Request", ex.getMessage(),
                                                  HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}

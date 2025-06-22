package ApiProject.RestaurantReservation.exceptions;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: CustomExceptionClass to handle reservation conflict exception
 */
public class DataConflitException extends RuntimeException {
    public DataConflitException(String message) {
        super(message);
    }
}

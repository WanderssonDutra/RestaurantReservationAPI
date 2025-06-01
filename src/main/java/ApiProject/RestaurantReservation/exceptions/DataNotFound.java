package ApiProject.RestaurantReservation.exceptions;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: CustomExceptionClass to handle data not found
 */
public class DataNotFound extends RuntimeException {
    public DataNotFound(String message) {
        super(message);
    }
}

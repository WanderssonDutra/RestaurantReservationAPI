package ApiProject.RestaurantReservation.exceptions;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: CustomExceptionClass to handle reservation time exception
 */
public class ReservationTimeException extends RuntimeException {
    public ReservationTimeException(String message) {
        super(message);
    }
}

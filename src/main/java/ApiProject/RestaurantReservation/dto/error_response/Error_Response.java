package ApiProject.RestaurantReservation.dto.error_response;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Record that stores information about an error
 * @param error error type message
 * @param message message describing the error
 * @param status status of the message
 */
public record Error_Response(String error, String message, int status) {

    public Error_Response(String error, String message, int status){
        this.error = error;
        this.message = message;
        this.status = status;
    }
}

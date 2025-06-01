package ApiProject.RestaurantReservation.dto.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * @param restaurantId
 * @param restaurantName
 * @param clientName
 * @param tableNumber
 * @param type
 * @param date
 * @param time
 */
public record ReservationResquestDTO (UUID restaurantId, String restaurantName,
                                      String clientName,int tableNumber, String type,
                                      LocalDate date, LocalTime time){
}

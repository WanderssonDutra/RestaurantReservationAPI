package ApiProject.RestaurantReservation.dto.reservation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 08/06/2025
 * @param restaurantId
 * @param restaurantName
 * @param clientName
 * @param tableNumber
 * @param date
 * @param time
 */
public record ReservationResquestDTO (@NotNull UUID restaurantId, String restaurantName,
                                      @NotBlank String clientName, @NotNull int tableNumber,
                                      @NotNull LocalDate date, @NotNull LocalTime time){
}

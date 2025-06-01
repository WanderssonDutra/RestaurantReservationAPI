package ApiProject.RestaurantReservation.dto.reservation;

import ApiProject.RestaurantReservation.entity.Reservation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Record that will receive data from the reservation entity
 */
public record ReservationResponseDTO(UUID id,String clientName, String restaurantName,
                                     UUID restaurantId, int tableNumber,String type,
                                     LocalDate date, LocalTime time) {

    public ReservationResponseDTO(Reservation reservation){
        this(reservation.getId(), reservation.getClientName(), reservation.getRestaurantTable()
                        .getRestaurant().getName(),reservation.getRestaurantTable()
                        .getRestaurant().getId(), reservation.getRestaurantTable()
                        .getTableNumber(), reservation.getType(),
                        reservation.getDate(), reservation.getTime());
    }
}

package ApiProject.RestaurantReservation.dto.reservation;

import ApiProject.RestaurantReservation.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: Record that will receive data from the reservation entity
 */
public record ReservationResponseDTO(UUID id, int code, String clientName, String restaurantName,
                                     UUID restaurantId, int tableNumber, Boolean isVip,
                                     LocalDate date, LocalTime time) {

    public ReservationResponseDTO(Reservation reservation){
        this(reservation.getId(), reservation.getCode(), reservation.getClientName(), reservation.getRestaurantTable()
                        .getRestaurant().getName(),reservation.getRestaurantTable()
                        .getRestaurant().getId(), reservation.getRestaurantTable()
                        .getTableNumber(), reservation.getRestaurantTable().getIsVip(),
                        reservation.getDate(), reservation.getTime());
    }
}

package ApiProject.RestaurantReservation.factory;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.entity.Reservation;
import ApiProject.RestaurantReservation.entity.RestaurantTable;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: A factory method design pattern class to create an instance of the reservation
 * entity
 */
public class ReservationFactory {
    public static Reservation createReservation(ReservationResquestDTO data, RestaurantTable table){
        return new Reservation(data, table);
    }
}

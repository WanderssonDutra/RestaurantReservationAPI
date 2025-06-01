package ApiProject.RestaurantReservation.factory;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.policy.ReservationDefaultPolicy;
import ApiProject.RestaurantReservation.policy.ReservationPolicy;
import ApiProject.RestaurantReservation.policy.ReservationVipPolicy;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: A factory method design pattern class to decide the strategy of the
 * Reservationpolicy interface and make an instance of it
 */
public class ReservationPolicyFactory {

    public static ReservationPolicy getPolicy(ReservationResquestDTO data){
        if(data.type().equalsIgnoreCase("default"))
            return new ReservationDefaultPolicy();
        if(data.type().equalsIgnoreCase("vip"))
            return new ReservationVipPolicy();
        return null;
    }
}

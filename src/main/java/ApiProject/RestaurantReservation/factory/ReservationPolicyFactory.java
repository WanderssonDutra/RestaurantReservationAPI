package ApiProject.RestaurantReservation.factory;

import ApiProject.RestaurantReservation.model.RestaurantTable;
import ApiProject.RestaurantReservation.policy.ReservationDefaultPolicy;
import ApiProject.RestaurantReservation.policy.ReservationMinimumTimePolicy;
import ApiProject.RestaurantReservation.policy.ReservationPolicy;
import ApiProject.RestaurantReservation.policy.ReservationVipPolicy;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: A factory method design pattern class to decide the strategy of the
 * Reservationpolicy interface and make an instance of it
 */
public class ReservationPolicyFactory {

    public static ReservationPolicy getPolicy(RestaurantTable restaurantTable){

        if(restaurantTable.getIsVip())
            return new ReservationVipPolicy();

        return new ReservationDefaultPolicy();
    }

    public static ReservationPolicy getPolicy(String str){

        if(str.equalsIgnoreCase("reservationtimepolicy"))
            return new ReservationMinimumTimePolicy();
        return null;
    }
}

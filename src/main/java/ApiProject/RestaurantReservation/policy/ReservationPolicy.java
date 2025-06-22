package ApiProject.RestaurantReservation.policy;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Strategy design pattern interface to decide custom reservation policies
 */
public interface ReservationPolicy {

    void validate(ReservationResquestDTO data);
}

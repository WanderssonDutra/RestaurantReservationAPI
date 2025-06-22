package ApiProject.RestaurantReservation.policy;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.exceptions.ReservationTimeException;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Strategy design pattern class with custom reservation policies
 */
public class ReservationDefaultPolicy implements ReservationPolicy{

    @Override
    public void validate(ReservationResquestDTO data) {

        if(data.time().getMinute() != 0 ||
                (data.time().getHour() < 14 || data.time().getHour() > 22)){

            throw new ReservationTimeException("The defined time is not allowed" +
                    " for default reservation, please reserve beetween 2pm and 10pm.");
        }
    }
}

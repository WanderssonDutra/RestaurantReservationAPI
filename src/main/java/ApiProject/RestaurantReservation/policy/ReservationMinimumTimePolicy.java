package ApiProject.RestaurantReservation.policy;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.exceptions.ReservationTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationMinimumTimePolicy implements ReservationPolicy{

    @Override
      public void validate(ReservationResquestDTO data){

        if(data.date().equals(LocalDate.now()) && data.time().isBefore(LocalTime.now()))

            throw new ReservationTimeException("Reservations cannot be made " +
                                               "before the current time");

        if(data.date().equals(LocalDate.now()) && data.time().isBefore(LocalTime.now().plusHours(2)))

            throw new ReservationTimeException("The reservation needs to be made " +
                                               "at least 2 hours before from " +
                                               "the reservation date.");
    }
}

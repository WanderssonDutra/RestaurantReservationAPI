package ApiProject.RestaurantReservation.repository.reservation;

import ApiProject.RestaurantReservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: repository of the reservation entity
 */
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByRestaurantTableRestaurantIdAndRestaurantTableTableNumber
            (UUID restaurantId, int tableNumber);

    @Query("""
            select count(r) >0 from reservation r
            where r.restaurantTable.restaurant.id = :restaurantId
            and r.restaurantTable.tableNumber = :tableNumber
            and r.date = :date
            and r.time = :time
            """)
    boolean existsByRestaurantIdAndTableNumberAndDateAndTime
            (
                    @Param("restaurantId") UUID restaurantId,
                    @Param("tableNumber") int tableNumber,
                    @Param("date")LocalDate date,
                    @Param("time")LocalTime time);
}

package ApiProject.RestaurantReservation.repository.restaurant_table;

import ApiProject.RestaurantReservation.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: repository of the RestaurantTable entity
 */
public interface RestaurantTableRepository  extends JpaRepository<RestaurantTable, UUID> {

    Optional<RestaurantTable> findByRestaurantIdAndTableNumber(UUID id, int tableNumber);


    boolean existsByRestaurantIdAndTableNumber(UUID restaurantId, int tableNumber);
}

package ApiProject.RestaurantReservation.repository.restaurant;

import ApiProject.RestaurantReservation.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: repository of the Restaurant entity
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    boolean existsByNameOrCnpjOrPhoneNumber(String name, String cnpj, String phoneNumber);

    boolean existsByRestaurantTablesTableNumberAndId(int tableNumber, UUID id);
}

package ApiProject.RestaurantReservation.dto.restaurant_table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 08/06/2025
 * Description: a record that receives request from the controller and transfers
 * the data to a RestaurantTable object
 * @param tableNumber the table number of a restaurant
 * @param isVip define if the restaurant table is a vip table
 */
public record RestaurantTableRequestDTO(@NotNull int tableNumber, @NotNull Boolean isVip) {
}

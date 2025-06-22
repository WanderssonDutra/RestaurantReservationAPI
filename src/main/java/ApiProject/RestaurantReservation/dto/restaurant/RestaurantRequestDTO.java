package ApiProject.RestaurantReservation.dto.restaurant;

import jakarta.validation.constraints.NotBlank;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 08/06/2025
 * Description: A record that receives requests from the controller and transfers
 * the data to the Restaurant object
 * @param name name of the restaurant
 * @param cnpj cnpj of the restaurant
 * @param phoneNumber the phone number of the restaurant
 */
public record RestaurantRequestDTO(@NotBlank String name,
                                   @NotBlank String cnpj,
                                   @NotBlank String phoneNumber) {
}

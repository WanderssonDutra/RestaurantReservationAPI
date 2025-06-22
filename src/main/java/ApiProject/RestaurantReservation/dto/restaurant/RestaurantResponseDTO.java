package ApiProject.RestaurantReservation.dto.restaurant;

import ApiProject.RestaurantReservation.model.Restaurant;

import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: A response record that receives the attributes of the Restaurant class in a Constructor
 * @param id identificator of the restaurant
 * @param name name of the restaurant
 * @param cnpj cnpj of the restaurant
 * @param phoneNumber phone number of the restaurant
 */
public record RestaurantResponseDTO(UUID id,String name, String cnpj, String phoneNumber) {

    public RestaurantResponseDTO(Restaurant restaurant){
        this(restaurant.getId(), restaurant.getName(), restaurant.getCnpj(),
                restaurant.getPhoneNumber());
    }
}

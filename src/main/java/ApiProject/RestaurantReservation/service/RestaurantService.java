package ApiProject.RestaurantReservation.service;

import ApiProject.RestaurantReservation.dto.restaurant.RestaurantRequestDTO;
import ApiProject.RestaurantReservation.dto.restaurant.RestaurantResponseDTO;
import ApiProject.RestaurantReservation.dto.restaurant_table.RestaurantTableRequestDTO;
import ApiProject.RestaurantReservation.model.Restaurant;
import ApiProject.RestaurantReservation.exceptions.DataConflitException;
import ApiProject.RestaurantReservation.exceptions.DataNotFound;
import ApiProject.RestaurantReservation.factory.ClassFactory;
import ApiProject.RestaurantReservation.repository.restaurant.RestaurantRepository;
import ApiProject.RestaurantReservation.repository.restaurant_table.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: The service class for the RestaurantController that applys the business logic
 */
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    /**
     * Description: returns a list of restaurant records
     */
    public ResponseEntity getAll(){

        if(restaurantRepository.findAll() == null)
            throw new DataNotFound("there are no restaurant records.");

        List<RestaurantResponseDTO> responseDTO = restaurantRepository.findAll().stream()
                .map(RestaurantResponseDTO::new).toList();
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * Description: creates a new restaurant record applying business logic
     * @param data The DTO that receives the data and transfers to an object
     */
    public void newRestaurant(RestaurantRequestDTO data){

        if(restaurantRepository.existsByNameOrCnpjOrPhoneNumber(data.name(), data.cnpj(),
                                                                data.phoneNumber()))
            throw new DataConflitException("there is already a restaurant record with " +
                                           "at least one of the datas.");

        restaurantRepository.save(ClassFactory.createRestaurant(data));
    }

    /**
     * Description: creates a new restaurantTable record applying business logic
     * @param data The DTO that receives the data and transfers to an object
     * @param restaurantId the restaurant identificator to use in business logic
     */
    public void newTable(RestaurantTableRequestDTO data, UUID restaurantId){

        if(restaurantRepository.existsByRestaurantTablesTableNumberAndId(data.tableNumber(),
                                                                         restaurantId))
            throw new DataConflitException("the table of this restaurant already exists.");

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new DataNotFound("the restaurant doesn't exists."));

        restaurantTableRepository.save(ClassFactory.createRestaurantTable(data, restaurant));
    }

    /**
     * Description: delete a Restaurant record applying business logic
     * @param id the restaurant identificator to use in the business logic
     */
    public void deleteRestaurant(UUID id){

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow
                (()-> new DataNotFound("The restaurant record was not found."));

        restaurantRepository.delete(restaurant);
    }
}

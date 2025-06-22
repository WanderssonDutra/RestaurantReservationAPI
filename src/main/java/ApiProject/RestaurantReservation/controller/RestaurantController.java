package ApiProject.RestaurantReservation.controller;

import ApiProject.RestaurantReservation.dto.restaurant.RestaurantRequestDTO;
import ApiProject.RestaurantReservation.dto.restaurant_table.RestaurantTableRequestDTO;
import ApiProject.RestaurantReservation.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: Controller of the restaurant entity class
 */
@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    /**
     * Description: request all restaurants records
     * @return ResponseEntity with a list and http status
     */
    @GetMapping("/all")
    public ResponseEntity getAllRestaurants(){
        return service.getAll();
    }
    /**
     * Description: request the creation of a new restaurantTable record
     * @return ResponseEntity with a message and a http status
     */
    @PostMapping("/newtable/{restaurantId}")
    public ResponseEntity requestNewTable(@RequestBody @Valid RestaurantTableRequestDTO data,
                                          @PathVariable UUID restaurantId){
        service.newTable(data, restaurantId);
        return ResponseEntity.ok("table successfully created.");
    }
    /**
     * Description: request the creation of a new restaurant record
     * @return ResponseEntity with a message and a http status
     */
    @PostMapping("/new")
    public ResponseEntity createRestaurant(@RequestBody @Valid RestaurantRequestDTO data){
        service.newRestaurant(data);
        return ResponseEntity.ok("The restaurant was successfully registered");
    }
    /**
     * Description: request to delete a restaurant record
     * @return ResponseEntity with a message and a http status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurant(UUID id){
        service.deleteRestaurant(id);
        return ResponseEntity.ok("The restaurant was successfully deleted.");
    }
}

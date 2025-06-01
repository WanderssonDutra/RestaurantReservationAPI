package ApiProject.RestaurantReservation.controller;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Controller of the reservation entity class
 */
@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    /**
     * Description: Request every reservation made
     * @return A ResponseEntity with a list of all reservations
     */
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.allReservations());
    }
    /**
     * Description: Request reservations filtered by the table number of a restaurant
     * @return A ResponseEntity with a list of reservations filtered by table number and
     * restaurant id
     */
    @GetMapping("/tablenumber")
    public ResponseEntity findByTableNumber(@RequestBody ReservationResquestDTO data){
        return ResponseEntity.ok(service.AllReservationsByRestaurantandTableNumber(data));
    }
    /**
     * Description: delete the reservation record by the id
     * @param id identificator of the reservation
     * @return a ResponseEntity with a http status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable UUID id){
        service.deleteReservation(id);
        return ResponseEntity.ok("Reservation successfully deleted.");
    }
    /**
     * Description: creates a new reservation record
     * @param data Data transfer operator that will transfer the information to
     * the reservation entity
     * @return A ResponseEntity with a http status
     */
    @PostMapping("/new")
    public ResponseEntity newReserve(@RequestBody ReservationResquestDTO data){
        service.newReservation(data);
        return ResponseEntity.ok("the reservation was successfully created.");
    }
}

package ApiProject.RestaurantReservation.controller;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResponseDTO;
import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
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
    public ResponseEntity<ReservationResponseDTO> getAll(){

        List<ReservationResponseDTO> allReservations = service.allReservations();
        return new ResponseEntity(allReservations, HttpStatus.OK);
    }
    /**
     * Description: Request reservations filtered by the table number of a restaurant
     * @return A ResponseEntity with a list of reservations filtered by table number and
     * restaurant id
     */
    @GetMapping("/tablenumber")
    public ResponseEntity<ReservationResponseDTO> findByTableNumber(@RequestBody ReservationResquestDTO data){

        List<ReservationResponseDTO> allByRestaurantAndTableNumber = service.
                                                                     AllReservationsByRestaurantAndTableNumber(data);
        return new ResponseEntity(allByRestaurantAndTableNumber, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getByRestaurantId(@PathVariable UUID id){

        List<ReservationResponseDTO> allByRestaurantId = service.allReservationsByRestaurantId(id);
        return new ResponseEntity(allByRestaurantId, HttpStatus.OK);
    }
    /**
     * Description: delete the reservation record by the id
     * @param id identificator of the reservation
     * @return a ResponseEntity with a http status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> deleteReservation(@PathVariable UUID id){

        ReservationResponseDTO responseDTO = service.deleteReservation(id);
        return  new ResponseEntity("Reservation succesfully deleted: " + responseDTO, HttpStatus.OK);
    }
    /**
     * Description: creates a new reservation record
     * @param data Data transfer operator that will transfer the information to
     * the reservation entity
     * @return A ResponseEntity with a http status
     */
    @PostMapping("/new")
    public ResponseEntity newReservation(@RequestBody @Valid ReservationResquestDTO data){
        service.newReservation(data);
        return ResponseEntity.ok("the reservation was successfully created.");
    }
}

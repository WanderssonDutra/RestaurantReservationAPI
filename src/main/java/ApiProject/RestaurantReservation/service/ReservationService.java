package ApiProject.RestaurantReservation.service;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResponseDTO;
import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.exceptions.ReservationConflitException;
import ApiProject.RestaurantReservation.exceptions.DataNotFound;
import ApiProject.RestaurantReservation.factory.ReservationPolicyFactory;
import ApiProject.RestaurantReservation.factory.ReservationFactory;
import ApiProject.RestaurantReservation.repository.reservation.ReservationRepository;
import ApiProject.RestaurantReservation.entity.RestaurantTable;
import ApiProject.RestaurantReservation.repository.restaurant_table.RestaurantTableRepository;
import ApiProject.RestaurantReservation.policy.ReservationPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: reservation service class to apply the business logic
 */
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final RestaurantTableRepository restaurantTableRepository;

    /**
     * Description: a list of every reservation records
     * @return a ReservationResponseDTO list
     */
    public List<ReservationResponseDTO> allReservations(){
         List<ReservationResponseDTO> all = repository.findAll().stream()
                                                            .map(ReservationResponseDTO::new)
                                                            .toList();
        return all;
    }

    /**
     * Description: a list of reservations filtered by restaurantId and table number
     * @param data data transfer operator to handle the information without exposing the entity
     * @return a ReservationResponseDTO list with filtered reservations
     */
    public List<ReservationResponseDTO> AllReservationsByRestaurantandTableNumber
                                        (ReservationResquestDTO data){
        List<ReservationResponseDTO> all = repository
                .findByRestaurantTableRestaurantIdAndRestaurantTableTableNumber
                        (data.restaurantId(), data.tableNumber()).stream()
                        .map(ReservationResponseDTO::new).toList();
        return all;
    }

    /**
     * Description: create a new reservation record applying business logic
     * @param data data transfer operator to handle the information without exposing the entity
     */
    public void newReservation(ReservationResquestDTO data){
        if(repository
                .existsByRestaurantIdAndTableNumberAndDateAndTime
                        (data.restaurantId(), data.tableNumber(), data.date(), data.time()))
            throw new ReservationConflitException("There is already a " +
                                                  "reservation at the apointed date.");
        ReservationPolicy policy = ReservationPolicyFactory.getPolicy(data);
        policy.validate(data);
        RestaurantTable restaurantTable = restaurantTableRepository.
                findByRestaurantIdAndTableNumber(data.restaurantId(), data.tableNumber())
                .orElseThrow(()-> new DataNotFound("The table does not exist."));
        repository.save(ReservationFactory.createReservation(data, restaurantTable));
    }

    /**
     * Description: deletes reservations records applying business logic
     * @param id UUID of the reservation record
     */
    public void deleteReservation(UUID id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new DataNotFound("The reservation does not exist.");
    }
}

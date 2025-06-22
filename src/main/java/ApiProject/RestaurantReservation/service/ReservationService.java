package ApiProject.RestaurantReservation.service;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResponseDTO;
import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.exceptions.DataConflitException;
import ApiProject.RestaurantReservation.exceptions.DataNotFound;
import ApiProject.RestaurantReservation.factory.ReservationPolicyFactory;
import ApiProject.RestaurantReservation.factory.ClassFactory;
import ApiProject.RestaurantReservation.model.Reservation;
import ApiProject.RestaurantReservation.repository.reservation.ReservationRepository;
import ApiProject.RestaurantReservation.model.RestaurantTable;
import ApiProject.RestaurantReservation.repository.restaurant_table.RestaurantTableRepository;
import ApiProject.RestaurantReservation.policy.ReservationPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
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
    public List<ReservationResponseDTO> AllReservationsByRestaurantAndTableNumber
                                        (ReservationResquestDTO data){

        if(!restaurantTableRepository.existsByRestaurantIdAndTableNumber
                (data.restaurantId(), data.tableNumber()))
            throw new DataNotFound("the table does not exists.");

        List<ReservationResponseDTO> all = repository
                .findByRestaurantTableRestaurantIdAndRestaurantTableTableNumber
                        (data.restaurantId(), data.tableNumber()).stream()
                        .map(ReservationResponseDTO::new).toList();

        return all;
    }

    public List<ReservationResponseDTO> allReservationsByRestaurantId(UUID restaurantId){

        List<ReservationResponseDTO> getAll = repository.findByRestaurantId
                (restaurantId).stream().map(ReservationResponseDTO::new).toList();

        if(getAll == null)
            throw new DataNotFound("No reservation found.");

        return getAll;
    }

    /**
     * Description: create a new reservation record applying business logic
     * @param data data transfer operator to handle the information without exposing the entity
     */
    public void newReservation(ReservationResquestDTO data){

        ReservationPolicy timePolicy = ReservationPolicyFactory.getPolicy
                                       ("reservationtimepolicy");
        timePolicy.validate(data);

        if(repository
                .existsByRestaurantIdAndTableNumberAndDateAndTime
                        (data.restaurantId(), data.tableNumber(), data.date(), data.time()))
            throw new DataConflitException("There is already a " +
                                                  "reservation at the apointed date.");

        RestaurantTable restaurantTable = restaurantTableRepository.
                findByRestaurantIdAndTableNumber(data.restaurantId(), data.tableNumber())
                .orElseThrow(()-> new DataNotFound("The table does not exist."));

        ReservationPolicy policy = ReservationPolicyFactory.getPolicy(restaurantTable);
        policy.validate(data);

        Random randomCode = new Random();
        int code = 0;
        while(true) {
            code = randomCode.nextInt(10000, 99999999);
            if (repository.existsByCode(code))
                continue;
            break;
        }
        repository.save(ClassFactory.createReservation(data, restaurantTable, code));
    }

    /**
     * Description: deletes reservations records applying business logic
     * @param id UUID of the reservation record
     */
    public ReservationResponseDTO deleteReservation(UUID id){

        Reservation reservation = repository.findById(id).orElseThrow
                                  (()-> new DataNotFound("the reservation was not found."));

        ReservationResponseDTO responseDTO = new ReservationResponseDTO(reservation);
        repository.delete(reservation);

        return responseDTO;
    }
}

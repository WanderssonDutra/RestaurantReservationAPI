package ApiProject.RestaurantReservation.factory;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import ApiProject.RestaurantReservation.dto.restaurant.RestaurantRequestDTO;
import ApiProject.RestaurantReservation.dto.restaurant_table.RestaurantTableRequestDTO;
import ApiProject.RestaurantReservation.model.Reservation;
import ApiProject.RestaurantReservation.model.Restaurant;
import ApiProject.RestaurantReservation.model.RestaurantTable;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: A factory method design pattern class to create an instance of an entity
 */
public class ClassFactory {

    public static Reservation createReservation(ReservationResquestDTO data,
                                                RestaurantTable table, int code){
        return new Reservation(data, table, code);
    }

    public static Restaurant createRestaurant(RestaurantRequestDTO data){
        return new Restaurant(data);
    }

    public static RestaurantTable createRestaurantTable(RestaurantTableRequestDTO data,
                                                        Restaurant restaurant){
        return new RestaurantTable(data, restaurant);
    }
}

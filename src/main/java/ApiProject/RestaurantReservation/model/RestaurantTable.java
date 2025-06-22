package ApiProject.RestaurantReservation.entity;

import ApiProject.RestaurantReservation.dto.restaurant_table.RestaurantTableRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 06/06/2025
 * Description: Entity class to persist restaurant_table datas
 */
@Entity(name = "restaurant_table")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int tableNumber;
    Boolean isVip;

    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    /**
     * Desdcription: Constructor to create an instance of an object
     * @param data DTO to transfer the data to an object
     * @param restaurant a restaurant record to create a relationship
     */
    public RestaurantTable(RestaurantTableRequestDTO data, Restaurant restaurant){
        this.tableNumber = data.tableNumber();
        this.isVip = data.isVip();
        this.restaurant = restaurant;
    }
}

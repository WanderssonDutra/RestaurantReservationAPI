package ApiProject.RestaurantReservation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;
/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
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

    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}

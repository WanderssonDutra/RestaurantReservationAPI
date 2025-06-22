package ApiProject.RestaurantReservation.model;

import ApiProject.RestaurantReservation.dto.reservation.ReservationResquestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * Description: Entity class to persist reservation datas
 */
@Entity(name = "reservation")
@Table(name = "reservation")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", nullable = false)
    private int code;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "restaurant_table_id")
    private RestaurantTable restaurantTable;

    /**
     * Creates a new reservation
     * @param data data tranrfer operation that will transfer the requested data to the entity
     * @param table related class entity in a many-to-one relationship
     */
    public Reservation(ReservationResquestDTO data, RestaurantTable table, int code){
        this.clientName = data.clientName();
        this.date = data.date();
        this.time = data.time();
        this.restaurantTable = table;
        this.code = code;
    }
}

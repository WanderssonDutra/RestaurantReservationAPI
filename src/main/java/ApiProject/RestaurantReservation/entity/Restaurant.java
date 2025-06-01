package ApiProject.RestaurantReservation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

/**
 * Author: Wandersson Sousa Dutra
 * Date: 01/06/2025
 * entity class to persist restaurant datas
 */
@Entity(name = "restaurant")
@Getter
@Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cnpj;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantTable> restaurantTables;
}

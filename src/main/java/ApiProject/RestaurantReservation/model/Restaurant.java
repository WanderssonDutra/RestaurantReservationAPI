package ApiProject.RestaurantReservation.model;

import ApiProject.RestaurantReservation.dto.restaurant.RestaurantRequestDTO;
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
@Table(name = "restaurant")
@Getter
@Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantTable> restaurantTables;

    /**
     * Constructor to create an instance of an object
     * @param data DTO to transfer the data to the object
     */
    public Restaurant(RestaurantRequestDTO data){
        this.name = data.name();
        this.cnpj = data.cnpj();
        this.phoneNumber = data.phoneNumber();
    }
}

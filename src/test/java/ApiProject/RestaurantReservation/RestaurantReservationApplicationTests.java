package ApiProject.RestaurantReservation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.DynamicPropertyRegistry;
@Testcontainers
@SpringBootTest
public class RestaurantReservationApplicationTests {

	@Container
	static PostgreSQLContainer<?> postgre = new PostgreSQLContainer<>("postgres:15")
			.withDatabaseName("testedb")
			.withUsername("postgres")
			.withPassword("postgres");
	@DynamicPropertySource
	static void configure(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url", postgre::getJdbcUrl);
		registry.add("spring.datasource.username", postgre::getUsername);
		registry.add("spring.datasource.password", postgre::getPassword);
	}
	@Test
	void contextLoads() {
	}
}


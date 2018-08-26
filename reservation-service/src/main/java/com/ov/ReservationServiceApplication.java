package com.ov;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {
	
	@Bean 
	CommandLineRunner commandLinerRunner(ReservationRepository reservationRepository) {
		return strings -> {
			Stream.of("Neymar", "Hazard", "Messi")
				  .forEach(e -> reservationRepository.save(new Reservation(e)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
}


@RefreshScope
@RestController
class MessageController {
	@Value("${message}")
	private String message;
	

	@RequestMapping("/message")
	public String message() {
		return this.message;
	}
}

	


@RepositoryRestResource()
interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByReservationName(@Param("q") String name);
}


@Entity
class Reservation {
	
	@Id @GeneratedValue
	private Long Id;
	
	private String reservationName;

	public Reservation() {
	}

	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}

	public Long getId() {
		return Id;
	}

	public String getReservationName() {
		return reservationName;
	} 
	
}
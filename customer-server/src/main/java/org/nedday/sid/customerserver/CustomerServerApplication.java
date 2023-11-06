package org.nedday.sid.customerserver;

import lombok.Builder;
import org.nedday.sid.customerserver.entities.Customer;
import org.nedday.sid.customerserver.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Anas").email("neddayanas@gmail.com").build(),
					Customer.builder().name("Akram").email("malyadiakram@gmail.com").build(),
					Customer.builder().name("Marouane").email("mouhibmarouane@gmail.com").build()

			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}

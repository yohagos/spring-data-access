package com.dataaccess.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of test customers
			repository.save(new Customer("Jack", "Winslow"));
			repository.save(new Customer("James", "Winslow"));
			repository.save(new Customer("Jack", "Sparrow"));
			repository.save(new Customer("Michelle", "Gonzales"));
			repository.save(new Customer("Kaur", "Bauer"));

			// fetch all test customers
			log.info("customer found with foundAll():");
			log.info("----------------------------------");
			repository.findAll().forEach(customer ->  {
				log.info(customer.toString());
			});

			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L)");
			log.info("------------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch all customer by lastname
			log.info("Customer found with with findByLastName('Winslow')");
			log.info("---------------------------------------");
			repository.findByLastname("Winslow").forEach(c -> {
				log.info(c.toString());
			});
			log.info("");
		};
	}

}

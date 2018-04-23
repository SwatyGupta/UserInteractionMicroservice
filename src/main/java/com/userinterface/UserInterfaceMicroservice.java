package com.userinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import com.userinterface.response.data.TransactionResponseRepository;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@Import(TransactionResponseRepository.class)
public class UserInterfaceMicroservice {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { UserInterfaceMicroservice.class }, args);
	}
}
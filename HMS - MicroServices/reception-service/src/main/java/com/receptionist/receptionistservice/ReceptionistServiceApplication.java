package com.receptionist.receptionistservice;

import com.receptionist.receptionistservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class ReceptionistServiceApplication {

	private final GuestRepository guestRepository;

	@Autowired
	public ReceptionistServiceApplication(GuestRepository guestRepository){
		this.guestRepository = guestRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReceptionistServiceApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.receptionist.receptionistservice"))
				.build();
	}

}
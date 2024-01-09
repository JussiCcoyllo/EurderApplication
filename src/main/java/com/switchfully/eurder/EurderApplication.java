package com.switchfully.eurder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.web.servlet.config.annotation.*;

@EnableJpaRepositories(basePackages = {"com.switchfully.eurder.repository"})
@SpringBootApplication(scanBasePackages = "com.switchfully.eurder.mapper")
@EntityScan({"com.switchfully.eurder.entity"})
@EnableWebMvc
public class EurderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurderApplication.class, args);
	}

}

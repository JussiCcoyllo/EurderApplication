package com.switchfully.eurder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

@SpringBootApplication(scanBasePackages = "com.switchfully.eurder.mapper")
public class EurderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurderApplication.class, args);
	}

}

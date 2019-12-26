package org.ygq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FistPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FistPersonApplication.class, args);
	}

}

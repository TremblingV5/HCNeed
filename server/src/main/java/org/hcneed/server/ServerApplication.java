package org.hcneed.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"org.hcneed.server.entities.models"}, basePackageClasses = Jsr310Converters.class)
@SpringBootApplication
@EnableScheduling
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

package com.srms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class SupportMonitoringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportMonitoringSystemApplication.class, args);
	}


	@Bean
	public Clock clock(){
		return Clock.systemDefaultZone();
	}

}

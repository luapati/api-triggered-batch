package com.batchTask.DbPoller;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class DbPollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPollerApplication.class, args);
	}
}
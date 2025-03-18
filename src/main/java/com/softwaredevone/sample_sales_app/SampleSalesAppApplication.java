package com.softwaredevone.sample_sales_app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleSalesAppApplication {
	public static void main(String[] args) {
		// Load .env variables
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_HOST_AND_PORT", dotenv.get("DB_HOST_AND_PORT"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("DB_USE_SSL", dotenv.get("DB_USE_SSL"));
		System.setProperty("DB_SERVER_TIMEZONE", dotenv.get("DB_SERVER_TIMEZONE"));


		SpringApplication.run(SampleSalesAppApplication.class, args);
	}
}

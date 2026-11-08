package com.devmeenah.microservice.product_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.mongodb.MongoDBContainer;

import io.restassured.RestAssured;
 
@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ProductServiceApplicationTests {
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort 
	private Integer port;
	@BeforeEach 
	void setup() {
		RestAssured.baseURI = "http://localhost:";
		RestAssured.port = port;
		//mongoDBContainer.start();
	}

	@Test
	void contextLoads() {
	}

}

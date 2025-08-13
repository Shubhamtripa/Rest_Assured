package com.sample.CRUD.withBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SampleDeleteTest {
	@Test
	public void deleteDataFromServer() {
RestAssured
	.given()
		
	.when()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_350")

	.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}

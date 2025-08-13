package com.sample.CRUD.withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {

	@Test
	public void getDataFromServer() {
		Response res = RestAssured.get("http://49.249.28.218:8091/projects");
		//System.out.println(res.prettyPrint());
		
		res.then().assertThat().statusCode(200)
		.log().all();
		
	}
}

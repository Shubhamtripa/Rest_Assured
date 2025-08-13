package com.sample.CRUD.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	@Test
	public void deleteDataFromServer() {
		
		Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_330");
		res.then().log().all();
		res.then().assertThat().statusCode(204);
	}

}

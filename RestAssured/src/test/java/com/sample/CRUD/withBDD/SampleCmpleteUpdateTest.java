package com.sample.CRUD.withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class SampleCmpleteUpdateTest {
	@Test
	public void putDataOnServer() {
		
	JSONObject jo = new JSONObject();
	jo.put("createdBy", "deepak");
	jo.put("projectName", "Apple_010");
	jo.put("status", "Created");
	jo.put("teamSize", 0);
RestAssured
	.given()
		.contentType(ContentType.JSON)
		.body(jo.toJSONString())
		
	.when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_350")

	.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}

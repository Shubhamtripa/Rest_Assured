package com.sample.CRUD.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void updateDataFromServer() {
		JSONObject jo = new JSONObject();
		jo.put("projectName", "BlackBarry_010");
	 
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jo.toJSONString());
		
		Response res = req.put("http://49.249.28.218:8091/project/NH_PROJ_330");
		
		res.then().assertThat().statusCode(200);
		res.then().log().all();
		
	}
}

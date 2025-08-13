package com.sample.CRUD.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {

	@Test
	public void postDataFromServer() {
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "deepak");
		jo.put("projectName", "Apple_010");
		jo.put("status", "Created");
		jo.put("teamSize", 0);
	 
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jo.toJSONString());
		
		Response res = req.post("http://49.249.28.218:8091/addProject");
		
		res.then().assertThat().statusCode(201);
		res.then().log().all();
		
	}
}

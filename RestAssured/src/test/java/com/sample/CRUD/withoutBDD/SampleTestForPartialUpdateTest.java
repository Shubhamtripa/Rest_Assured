package com.sample.CRUD.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {
	@Test
	public void patchDataToServer() {
		JSONObject jo = new JSONObject();
		jo.put("projectName", "Kela");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jo.toJSONString());
		
		Response res = req.patch("http://49.249.28.218:8091/project/NH_PROJ_330");
		res.then().log().all();
		res.then().assertThat().statusCode(200);
	}

}

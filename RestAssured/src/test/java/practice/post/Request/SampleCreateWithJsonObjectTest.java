package practice.post.Request;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleCreateWithJsonObjectTest {
	@Test
	public void postDataToServer() {
		JSONObject jo = new JSONObject();
		jo.put("createdBy", "deepak");
		jo.put("projectName", "Apple_111");
		jo.put("status", "Created");
		jo.put("teamSize", 0);
	 
		given()
			.contentType(ContentType.JSON)
			.body(jo.toJSONString())
		
		.when()
			.post("http://49.249.28.218:8091/addProject")
		
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}

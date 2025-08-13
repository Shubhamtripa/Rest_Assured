package practice.post.Request;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleCreateWithHashMapTest {
	@Test
	public void postDataToServer() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("createdBy", "deepak");
		hm.put("projectName", "Apple_231");
		hm.put("status", "Created");
		hm.put("teamSize", 0);
	 
		given()
			.contentType(ContentType.JSON)
			.body(hm)
		
		.when()
			.post("http://49.249.28.218:8091/addProject")
		
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}

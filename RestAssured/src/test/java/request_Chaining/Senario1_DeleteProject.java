package request_Chaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.ProjectPOJO;

public class Senario1_DeleteProject {
	@Test
	public void SampleTest() {
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		//API-1 ==> add project to server
		ProjectPOJO pObj = new ProjectPOJO("deepak", "Apple_"+ranNum, "Created", 0);
		
		Response res = given()
			.contentType(ContentType.JSON)
			.body(pObj)
		
		.when()
			.post("http://49.249.28.218:8091/addProject");
		
		res.then()
			.assertThat().statusCode(201)
			.log().all();
		
		//capture the data from response
		String projectId = res.jsonPath().get("projectId");
		
		//API-2 delete project
		given()
			.delete("http://49.249.28.218:8091/project/"+projectId)
		.then()
		.log().all();
	}

}

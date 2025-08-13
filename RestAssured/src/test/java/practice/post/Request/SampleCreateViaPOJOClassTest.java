package practice.post.Request;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassUtility.ProjectPOJO;

public class SampleCreateViaPOJOClassTest {
	@Test
	public void postDataToServer() {
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		//create object of POJO class
		ProjectPOJO pObj = new ProjectPOJO("deepak", "Apple_"+ranNum, "Created", 0);
		
		given()
			.contentType(ContentType.JSON)
			.body(pObj)
		
		.when()
			.post("http://49.249.28.218:8091/addProject")
		
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}

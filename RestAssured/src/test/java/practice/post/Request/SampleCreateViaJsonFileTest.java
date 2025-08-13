package practice.post.Request;

import static io.restassured.RestAssured.*;

import java.io.File;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleCreateViaJsonFileTest {
	@Test
	public void postDataToServer() {
		
		given()
			.contentType(ContentType.JSON)
			.body(new File("./SampleData.json"))
		
		.when()
			.post("http://49.249.28.218:8091/addProject")
		
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}

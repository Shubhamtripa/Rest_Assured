package practice.reponseValidation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class verifyResponseHeader {
	@Test
	public void verifyHeader() {
		
		Response res = given()
			.get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		
		res.then().assertThat().contentType(ContentType.JSON);
		res.then().assertThat().statusLine("HTTP/1.1 200 ");
		res.then().assertThat().statusCode(200);
		res.then().assertThat().header("Transfer-Encoding", "chunked");
	}

}

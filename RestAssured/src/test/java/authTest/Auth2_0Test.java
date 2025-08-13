package authTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Auth2_0Test {
	@Test
	public void sampleTest() {
		//API-1 get auth 
		Response res = given()
			.formParams("client_id", "ninza-client")
			.formParams("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
			.formParam("grant_type", "client_credentials")
			
		.when()
			.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
			
		res.then()
			.log().all();
		//capture token from the response [keyclock (Oauth2.0) ]
		String token = res.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.log().all() 
		.when()
			.get("http://49.249.28.218:8091/projects")
		.then()
			.log().all();
	}

}

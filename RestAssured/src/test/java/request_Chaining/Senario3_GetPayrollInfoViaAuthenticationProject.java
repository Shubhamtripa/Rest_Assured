package request_Chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Senario3_GetPayrollInfoViaAuthenticationProject {
	@Test
	public void postDataToServer() {

		//API-1 get auth 
		Response res = given()
			.formParams("client_id", "ninza-client")
			.formParams("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
			.formParam("grant_type", "client_credentials")
			
		.when()
			.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
			
		res.then()
			.log().all();
		
		//capture data from response
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		//API-2 Get Payroll Info
		given()
			.auth().oauth2(token)
			.get("http://49.249.28.218:8091/admin/payrolls")
		
		.then()
			.log().all();
	}
}

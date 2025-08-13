package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestUsingMtdChainingTest {
@Test
public void sampleGetReqTest() {
	//Response resp = RestAssured.get("https://reqres.in/api/users");
	
	//System.out.println(resp.prettyPrint());
	
	//method chaining
	RestAssured.get("https://reqres.in/api/users").prettyPrint();
	RestAssured
	.given()
	.then()
	.log()
	.all();
}

}

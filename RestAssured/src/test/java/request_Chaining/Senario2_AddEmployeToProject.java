package request_Chaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.EmployeePOJO;
import pojoClassUtility.ProjectPOJO;

public class Senario2_AddEmployeToProject {
	@Test
	public void sampleTest () {
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
		String projectName = res.jsonPath().get("projectName");
		
		//API-2 Add Employee To same project
		
		EmployeePOJO empPojo = new EmployeePOJO("Architect", "24/10/1999", "deepka@Gmail.com", "user"+ranNum, 18, "7845129630", projectName, "ROLE_EMPLOYEE", "user"+ranNum);
		given()
			.contentType(ContentType.JSON)
			.body(empPojo)
			
		.when()	
			.post("http://49.249.28.218:8091/employees")
			
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}

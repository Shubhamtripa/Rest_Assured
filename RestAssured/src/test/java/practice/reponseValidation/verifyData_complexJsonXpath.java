package practice.reponseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;


public class verifyData_complexJsonXpath {
	@Test
	public void sampleTest() {

		Response res = given()
				.get("http://49.249.28.218:8091/projects-paginated");
			//res.then().log().all();
		
		List<String> list = JsonPath.read(res.asString(), ".content[*].projectName");
		for(String data : list) {
		System.out.println(data);
		}
		List<String> list1 = JsonPath.read(res.asString(), ".content[*].[?(@.projectName=='Airtel1970')].projectId");
		String actProjectId = list1.get(0);
		
		
		Assert.assertEquals(actProjectId, "NH_PROJ_551");
		
		//extract firstProjectID
		//DB validation
		//request chaining
		
		
	}

}

package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status) {
		//String pName= "Gooogle";
		//String status = "Created";
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Deepak\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(reqBody)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.log().all();
	}
	
@DataProvider
public Object[][] getData() {
	Object[][] obj = new Object[3][2];
	obj[0][0]="AiirIndia_1";
	obj[0][1]="Created";
	
	obj[1][0]="AiirIndia_2";
	obj[1][1]="Created";
	
	obj[2][0]="AiirIndia_3";
	obj[2][1]="Created";
	return obj;
	

}
}

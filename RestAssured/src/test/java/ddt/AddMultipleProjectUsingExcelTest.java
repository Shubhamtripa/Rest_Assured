package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import file_Utility.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectUsingExcelTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status) {
	
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
public Object[][] getData() throws Throwable {
	ExcelUtility elib = new ExcelUtility();
	int count = elib.getRowCount("sheet1");
	System.out.println(count);
	Object[][] obj = new Object[count][2];
	
	for(int i=0;i<count;i++) {
		obj[i][0]=elib.getDataFromExcel("sheet1", i+1, 0);
		obj[i][1]=elib.getDataFromExcel("sheet1", i+1, 1);
	}
	return obj;
}
}

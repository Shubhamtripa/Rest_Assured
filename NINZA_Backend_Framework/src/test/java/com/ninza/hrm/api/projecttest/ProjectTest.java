package com.ninza.hrm.api.projecttest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseClass.BaseAPIClass;
import com.ninza.hrm.api.genericUtility.DataBaseUtility;
import com.ninza.hrm.api.genericUtility.FileUtility;
import com.ninza.hrm.api.genericUtility.JavaUtility;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;

import co.ninza.hrm.constants.endpoints.IEndpoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectTest extends BaseAPIClass{
	ProjectPOJO pObj;
	JavaUtility jlib = new JavaUtility();
	FileUtility flib = new FileUtility();
	DataBaseUtility dblib = new DataBaseUtility();
	
	@Test
	public void addSingleProjectWithCreatedTest() throws Throwable {
//		Random random = new Random();
//		int ranNum = random.nextInt(1000);
				
		String baseURI=flib.getDataFromPropertyFile("BaseURI");
		String DBURL=flib.getDataFromPropertyFile("DBURL");
		String userName=flib.getDataFromPropertyFile("DB_Username");
		String password=flib.getDataFromPropertyFile("DB_Password");
		
		String expSucMsg = "Successfully Added";
		String projectName = "Apple_"+jlib.getRandomNum();
		//create object of POJO class
		pObj = new ProjectPOJO("deepak", projectName, "Created", 0);
		
		//verify the projectName in API layer
		Response res =given()
						.spec(reqSpecObj)
						//.contentType(ContentType.JSON)
						.body(pObj)
					
						.when()
							//.post(baseURI+"/addProject")
							//.post(baseURI+IEndpoint.ADDProj);
							.post(IEndpoint.ADDProj);
				
					res.then()
						.assertThat().statusCode(201)
						.assertThat().time(Matchers.lessThan(3000L))
						//.assertThat().contentType(ContentType.JSON)
						.spec(resSpecObj)
						.log().all();	
					String actprojectName = res.jsonPath().get("projectName");
					Assert.assertEquals(projectName, actprojectName);
					
					String actMsg = res.jsonPath().get("msg");
					Assert.assertEquals(expSucMsg, actMsg);
					
					//verify the projectName in API layer
//					  dblib.getDBConnection(DBURL, userName, password);
//					  dblib.executeSelectQuery("Select * from project");
//					dblib.closeDBConnection();
/*					boolean flag = false;
					Driver driver = new Driver();
					DriverManager.registerDriver(driver);
					Connection conn = DriverManager.getConnection(DBURL, userName,password);
					ResultSet result = conn.createStatement().executeQuery("Select * from project");
					while (result.next()) {
						if(result.getString(4).equals(projectName))
						{
							flag=true;
							break;
						}
					}
					conn.close();
					Assert.assertTrue(flag,"Project in db is not verified");
*/
					}
@Test(dependsOnMethods = "addSingleProjectWithCreatedTest")
public void createDuplicateProjectTest() throws Throwable {

	given()
		.spec(reqSpecObj)
		//.contentType(ContentType.JSON)
		.body(pObj)

	.when()
		//.post(baseURI+"/addProject")
//		.post(baseURI+IEndpoint.ADDProj)
		.post(IEndpoint.ADDProj)

	.then()
		.assertThat().statusCode(409)
		.log().all();
}
}

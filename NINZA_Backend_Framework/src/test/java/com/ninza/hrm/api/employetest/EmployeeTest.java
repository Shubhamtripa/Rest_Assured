package com.ninza.hrm.api.employetest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseClass.BaseAPIClass;
import com.ninza.hrm.api.genericUtility.DataBaseUtility;
import com.ninza.hrm.api.genericUtility.FileUtility;
import com.ninza.hrm.api.genericUtility.JavaUtility;
import com.ninza.hrm.api.pojoclass.EmployeePOJO;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;

import co.ninza.hrm.constants.endpoints.IEndpoint;
import io.restassured.response.Response;


public class EmployeeTest extends BaseAPIClass{

	JavaUtility jlib = new JavaUtility();
	FileUtility flib = new FileUtility();
	DataBaseUtility dblib= new DataBaseUtility();
	@Test
	public void addEmploye() throws Throwable {
		
		String projectName = "Apple_"+jlib.getRandomNum();
		String userName = "user"+jlib.getRandomNum();
				
		//API-1 ==> add project to server
		ProjectPOJO pObj = new ProjectPOJO("deepak", projectName, "Created", 0);
		 given()
			.spec(reqSpecObj)
			.body(pObj)
		
		.when()
			.post(IEndpoint.ADDProj)
		
		.then()
			.log().all();
		
		//API-2 Add Employee To same project
		EmployeePOJO empPojo = new EmployeePOJO("Architect", "24/10/1999", "deepka@Gmail.com",
												userName, 18, "7845129630", projectName, "ROLE_EMPLOYEE", userName);
		Response res = given()
						.spec(reqSpecObj)
						.body(empPojo)
			
					.when()	
						.post(IEndpoint.ADDEmp);
			
					res.then()
						.assertThat().statusCode(201)
						.time(Matchers.lessThan(3000L))
						.spec(resSpecObj)
						.log().all();
		
	}
}

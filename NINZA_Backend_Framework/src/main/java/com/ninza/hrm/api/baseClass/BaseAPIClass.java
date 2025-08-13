package com.ninza.hrm.api.baseClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.api.genericUtility.DataBaseUtility;
import com.ninza.hrm.api.genericUtility.FileUtility;
import com.ninza.hrm.api.genericUtility.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {
	JavaUtility jlib = new JavaUtility();
	FileUtility flib = new FileUtility();
	DataBaseUtility dblib = new DataBaseUtility();
	public static RequestSpecification reqSpecObj;
	public static ResponseSpecification resSpecObj;
	
	@BeforeSuite
	public void configBS() throws Throwable {
		String DBURL=flib.getDataFromPropertyFile("DBURL");
		String userName=flib.getDataFromPropertyFile("DB_Username");
		String password=flib.getDataFromPropertyFile("DB_Password");
		
		dblib.getDBConnection(DBURL, userName, password);
		System.out.println("========Connect TO DB===========");
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		//builder.setAuth(basic("userName", "password"));
		//builder.addHeader("", ""); 
		builder.setBaseUri(flib.getDataFromPropertyFile("BaseURI"));
		reqSpecObj = builder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		resSpecObj = resBuilder.build();
	}

	@AfterSuite
	public void configAS() throws Throwable {
		dblib.closeDBConnection();
		System.out.println("========DB Disconnect===========");
		
	
	}
}

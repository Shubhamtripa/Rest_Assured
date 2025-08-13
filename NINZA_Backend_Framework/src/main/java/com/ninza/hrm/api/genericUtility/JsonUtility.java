package com.ninza.hrm.api.genericUtility;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JsonUtility {
	FileUtility flib = new FileUtility();
	/**
	 * get the JSON data based on json complex xpath
	 * @param resp
	 * @param jsonXpath
	 * @return
	 */
	public String getDataOnJsonPath(Response resp, String jsonXpath) {
		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
		return list.get(0).toString();
	}

	/**
	 * get the xmlData from based on xml complex xpath
	 * @param resp
	 * @param xmlpath
	 * @return
	 */
	public String getDataOnXpathPath(Response resp, String xmlpath) {
		return resp.xmlPath().get(xmlpath);
	}
	
	/**
	 * 
	 * @param resp
	 * @param jsonxpath
	 * @param expectedData
	 * @return
	 */
	public boolean VerifyDataOnJsonPath(Response resp, String jsonxpath, String expectedData) {
		List<String> list =JsonPath.read(resp.asString(), jsonxpath);
		boolean flag = false;
		for(String str : list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData+" is available==PASS");
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println(expectedData+" is not available==FAIL");

		}
		return flag;
	}
	
	public String getAcessToken() throws Throwable {
		String client_id=flib.getDataFromPropertyFile("Client_Id");
		String client_secret=flib.getDataFromPropertyFile("Client_Secret");
		Response resp = given()
					.formParam("client_id", client_id)
					.formParam("client_secret", client_secret)
					.formParam("grant_type", "client_credentials")
				.when()
					.post("http://49.248.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
			resp.then()
				.log().all();
			//capture data from the response
			String token = resp.jsonPath().get("access_token");
			return token;
					
	}
}

package encryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdatePayInfoViaAESEncryptTest {
	/**
	 * private key : Ac03tEam@j!tu_#1
	 */

	@Test
	public void sampleTest() {
		String privateKey = "Ac03tEam@j!tu_#1";
		String data = "shubham";
		String jBody = "{ \"employee\": { \"empId\":\"NH_PROJ_1671\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 5000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }";
		given()
			.body(jBody)
		.when()
			.put("http://49.249.28.218:8091/payroll")
		.then()
			.log().all();
		
	}
}

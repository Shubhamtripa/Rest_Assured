package authTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BearerTokenTest {
	@Test
	public void sampleTest() {
		given()
			.auth().oauth2("P_aL_YNN03Djo5O_BrzAmyWqnTONEe4G5HT8pzgJPhkp3cXOahxYKqVvJ1I2o4P9DhSBKZbeB2ALTDalkisJ8Mg")
			.log().all() 
		.when()
			.get("http://49.249.28.218:8091/projects")
		.then()
			.log().all();
	}

}

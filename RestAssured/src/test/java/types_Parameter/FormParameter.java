package types_Parameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FormParameter {
	@Test
	public void sampleTest() {
		given()
			.formParam("teamSize", "10")
			.log().all()
		.when()
			.post("http://49.249.28.218:8091/project")
		.then()
			.log().all();
	}

}

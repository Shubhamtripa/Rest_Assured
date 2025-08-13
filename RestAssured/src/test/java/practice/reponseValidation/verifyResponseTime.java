package practice.reponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.response.Response;

public class verifyResponseTime {
	@Test
	public void verifyHeader() {
		
		Response res = given()
			.get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		
		long timetaken = res.time();
		System.out.println(timetaken);
		
		long timetakenSec = res.timeIn(TimeUnit.SECONDS);
		System.out.println(timetakenSec);
		
		res.then().assertThat().time(Matchers.lessThan(900L));
		
		res.then().assertThat().time(Matchers.greaterThan(300L));
		
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(1000L)).and(Matchers.greaterThan(300L)));
	}

}

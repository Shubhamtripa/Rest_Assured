package practice;


import org.testng.annotations.Test;

import com.backend.testing.A;

import static com.backend.testing.A.*;

public class Run1 {

	@Test
	public void sampleTest() {
//		given();
//		when();		
//		then();
		A a1 = new A();
		//a1.a().b().c();
		
		a1.a().b().c().d();
	}
}

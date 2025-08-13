package panCardMock;

import org.mockito.Mockito;

class PANCard{
	public String isvalid(String panCard) {
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) {
			return "is valid pan";
		}
		else
		{
			return "is invalid pan";
		}
	}
	public static PANCard getMockObject() {
		PANCard mocObj = Mockito.mock(PANCard.class);
						 Mockito.when(mocObj.isvalid("ASDFG1452B")).thenReturn("valid PAN card");
						 Mockito.when(mocObj.isvalid("ASDFG1452M")).thenReturn("valid PAN card");
						 Mockito.when(mocObj.isvalid("ASDFG1452X")).thenReturn("invalid PAN card");
		return mocObj;
	}
}
public class MockingTest {

	public static void main(String[] args) { 
			
		PANCard obj = PANCard.getMockObject();
		System.out.println(obj.isvalid("ASDFG1452V"));
	}

}

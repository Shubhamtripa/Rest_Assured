package practice_Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Run2_Deserialization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fis = new FileInputStream("./f.txt");

ObjectInputStream objInput = new ObjectInputStream(fis);
NFSGame user1Obj = (NFSGame) objInput.readObject();

System.out.println(user1Obj.name);
System.out.println(user1Obj.level);
System.out.println(user1Obj.score);
System.out.println(user1Obj.life);
 
	}

}

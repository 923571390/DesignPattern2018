package AnimalState;

import java.util.Scanner;

public class UnhealthyState extends State {

	@Override
	public boolean canBeFed() {
		
		System.out.println("This animal is sick and can't eat. Cure it and feed it again?(Y/N)");
		Scanner in=new Scanner(System.in);
		String s=in.next();
		if(s.charAt(0)=='Y') {
			System.out.println("Healing magic!");
			return true;
		}
		else return false;
	}

	@Override
	public boolean isItHealthy() {
		return false;
	}

}

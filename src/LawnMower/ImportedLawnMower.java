package LawnMower;

public class ImportedLawnMower {

	public ImportedLawnMower() {
		
	}
	
	public void charge110V(int voltage) {
		if (voltage == 110) {
			System.out.println("Lawn mower starts working!");
		}
		else {
			System.out.println("The current input voltage does not meet the specifications of the imported lawn mower！");
		}
	}
}

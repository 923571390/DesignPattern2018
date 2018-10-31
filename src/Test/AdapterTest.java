package Test;
import LawnMower.Adapter220V;
import LawnMower.ImportedLawnMower;
import LawnMower.PowerPort220V;

public class AdapterTest {

	public static void main(String[] args) {
		Adapter220V adapter = new Adapter220V();
		ImportedLawnMower lawnMower = new ImportedLawnMower();
		PowerPort220V powerport = new PowerPort220V();
		
		lawnMower.charge110V(powerport.output220v());
		lawnMower.charge110V((adapter.Convert220vTo110V()));
	}

}

package Test;
import Base.Adapter220V;
import Base.ImportedLawnMower;
import Base.PowerPort220V;

public class Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adapter220V adapter = new Adapter220V();
		ImportedLawnMower lawnMower = new ImportedLawnMower();
		PowerPort220V powerport = new PowerPort220V();
		
		lawnMower.charge110V(powerport.output220v());
		lawnMower.charge110V((adapter.Convert220vTo110V()));
	}

}

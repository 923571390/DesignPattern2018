package LawnMower;

public class Adapter220V extends PowerPort220V implements VoltageConverter{

	public Adapter220V() {
	}

	@Override
	public int Convert220vTo110V() {
		this.output220v();
		return 110;
	}

}

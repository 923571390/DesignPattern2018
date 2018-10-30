package Base;

public class Adapter220V extends PowerPort220V implements VoltageConverter{

	public Adapter220V() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int Convert220vTo110V() {
		// TODO Auto-generated method stub
		this.output220v();
		return 110;
	}

}

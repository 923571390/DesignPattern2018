package Base;

public class YellowWall extends FacilityDecorator {
	public YellowWall(Facility decoratedFacility) {
		super(decoratedFacility);
	}

	@Override
	public void getDescription() {
		decoratedFacility.getDescription();
		paintYellow();
	}

	private void paintYellow() {
		System.out.print(" with yellow walls");
	}
}

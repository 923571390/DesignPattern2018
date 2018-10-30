package Base;

public class WhiteWall extends FacilityDecorator {

	public WhiteWall(Facility decoratedFacility) {
		super(decoratedFacility);
	}

	@Override
	public void getDescription() {
		decoratedFacility.getDescription();
		paintWhite();
	}

	private void paintWhite() {
		System.out.print(" with white walls");
	}

}

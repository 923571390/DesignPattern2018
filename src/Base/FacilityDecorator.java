package Base;

import Building.Facility;

public abstract class FacilityDecorator implements Facility {

	protected Facility decoratedFacility;

	public FacilityDecorator(Facility decoratedFacility) {
		this.decoratedFacility = decoratedFacility;
	}

	@Override
	public void getDescription() {
		decoratedFacility.getDescription();
	}
}

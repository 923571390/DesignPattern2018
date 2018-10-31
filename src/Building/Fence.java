package Building;

import Base.FacilityDecorator;

public class Fence extends FacilityDecorator {
	public Fence(Facility decoratedFacility) {
		super(decoratedFacility);
	}

	@Override
	public void getDescription() {
		decoratedFacility.getDescription();
		buildFence();
	}

	private void buildFence() {
		System.out.print(" with fence");
	}
}

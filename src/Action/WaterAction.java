package Action;

import Building.BigFarmLand;
import Building.FarmLand;
import StoreHouse.StoreHouse;

public class WaterAction implements VisitorAction {

	public WaterAction() {
	}

	@Override
	public void visit(StoreHouse store) throws Exception {
		throw new Exception("Action not allowed!");
	}

	@Override
	public void visit(FarmLand land) {
		land.setWet(true);
		land.notifyAllObservers();
	}

}
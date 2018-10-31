package Action;

import Building.BigFarmLand;
import Building.FarmLand;
import StoreHouse.StoreHouse;

public class WaterAction implements VisitorAction {

	public WaterAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(StoreHouse store) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Action not allowed!");
	}

	@Override
	public void visit(FarmLand land) {
		// TODO Auto-generated method stub
		land.setWet(true);
		land.notifyAllObservers();
	}

}
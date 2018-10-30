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
		throw new Exception("不可以对仓库进行收获操作。");
	}

	@Override
	public void visit(FarmLand land) {
		// TODO Auto-generated method stub
		land.setWet(true);
		land.notifyAllObservers();
	}

}
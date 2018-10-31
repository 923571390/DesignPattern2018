package Action;

import java.util.Iterator;

import Building.BigFarmLand;
import Building.FarmLand;
import Enum.FARMLANDTYPE;
import Plant.Bamboo;
import Plant.Plant;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;
import StoreHouse.StoreHouse;

public class HarvestAction implements VisitorAction {

	public HarvestAction() {
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
		Iterator iter = land.getEntities().iterator();
		
		while(iter.hasNext()) {
//			System.out.println("harvest");
			Plant currentPlant = (Plant) iter.next();
			if (currentPlant.mature()) {
				iter.remove();
				// 待改成enum 如果是竹子田地
				if (land.getName() == "Bamboo Farmland") {
					BambooStore store = BambooStore.getInstance();
					store.increase(1);
				}
				else {
					GrassStore store = GrassStore.getInstance();
					store.increase(1);
				}
			}
		}
	}

}

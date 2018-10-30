package Action;

import java.util.Iterator;

import Base.BigFarmLand;
import Base.FARMLANDTYPE;
import Base.FarmLand;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.GrassStore;
import ChainOfPesponsibility.StoreHouse;
import Plant.Bamboo;
import Plant.Plant;

public class HarvestAction implements VisitorAction {

	public HarvestAction() {
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
		Iterator iter = land.getEntities().iterator();
		
		while(iter.hasNext()) {
			Plant currentPlant = (Plant) iter.next();
			if (currentPlant.mature()) {
				land.getEntities().remove(1);
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

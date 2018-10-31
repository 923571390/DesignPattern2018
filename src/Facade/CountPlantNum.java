package Facade;

import Building.Farm;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

public class CountPlantNum implements Statistics{

	private int sum = 0;
	
	@Override
	public int getNum(Farm farm) {
		
				
		BambooStore banbooStore =BambooStore.getInstance();
		
		GrassStore grassStore = GrassStore.getInstance();
		
		this.sum += banbooStore.getSum();
		this.sum += grassStore.getSum();
		
		Building.FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		Building.FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Grass Farmland");
		this.sum += bambooFarm.getEntitiesNum();
		this.sum += grassFarm.getEntitiesNum();
				
		return this.sum;
		
	}

	
}

package Facade;

import Base.Farm;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.GrassStore;

public class CountPlantNum implements Statistics{

	private int sum = 0;
	
	@Override
	public int getNum(Farm farm) {
		
				
		//BambooStore banbooStore =BambooStore.getInstance();
		
		GrassStore grassStore = GrassStore.getInstance();
		
		//sum += banbooStore.getSum();
		this.sum += grassStore.getSum();
		
		//FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		Base.FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		//sum += bambooFarm.getPlantsNum();
		this.sum += grassFarm.getEntitiesNum();
		
		
		
		//need a method to get the number of plant
		
		return this.sum;
		
	}

	
}

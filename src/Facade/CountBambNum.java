package Facade;

import Building.Farm;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

public class CountBambNum implements Statistics{
	private int sum = 0;	
	@Override
	public int getNum(Farm farm) {
		
		BambooStore banbooStore =BambooStore.getInstance();
		
		//GrassStore grassStore = GrassStore.getInstance();
		
		this.sum += banbooStore.getSum();
		//sum += grassStore.getSum();
		
		Building.FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		//FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		this.sum += bambooFarm.getEntitiesNum();
		//sum += grassFarm.getPlantsNum();
		
		
		
		//need a method to get the number of plant
		
		return this.sum;
		
	}

}

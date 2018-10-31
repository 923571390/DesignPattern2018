package Facade;

import Building.Farm;
import Building.FarmLand;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

public class CountGrassNum implements Statistics{
	
	private int sum = 0;	
	@Override
	public int getNum(Farm farm) {
		
		
		
		//BambooStore banbooStore =BambooStore.getInstance();
		
		GrassStore grassStore = GrassStore.getInstance();
		
		//this.sum += banbooStore.getSum();
		this.sum += grassStore.getSum();
		
		//FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		Building.FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Grass Farmland");
		//this.sum += bambooFarm.getEntitiesNum();
		this.sum += grassFarm.getEntitiesNum();
		
		
		
		//need a method to get the number of plant
		
		return this.sum;
		
	}
}

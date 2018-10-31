package Facade;

import Building.Farm;
import Building.FarmLand;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

//Count the number of grasses
public class CountGrassNum implements Statistics{
	
	private int sum = 0;	
	@Override
	public int getNum(Farm farm) {
				
		GrassStore grassStore = GrassStore.getInstance();
		
		this.sum += grassStore.getSum();
		
		Building.FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Grass Farmland");
		this.sum += grassFarm.getEntitiesNum();
		
				
		return this.sum;
		
	}
}

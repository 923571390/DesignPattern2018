package Facade;

import Building.Farm;

import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

//Count the number of bamboo
public class CountBambNum implements Statistics{
	private int sum = 0;	
	@Override
	public int getNum(Farm farm) {
		
		BambooStore banbooStore =BambooStore.getInstance();
				
		this.sum += banbooStore.getSum();
		
		Building.FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		this.sum += bambooFarm.getEntitiesNum();
		
		
		return this.sum;
		
	}

}

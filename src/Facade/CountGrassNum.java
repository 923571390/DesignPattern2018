package Facade;

import Base.Farm;
import Base.FarmLand;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.GrassStore;

public class CountGrassNum implements Statistics{
	
	private int sum = 0;	
	@Override
	public int getNum(Farm farm) {
		
		
		
		BambooStore banbooStore =BambooStore.getInstance();
		
		GrassStore grassStore = GrassStore.getInstance();
		
		this.sum += banbooStore.getSum();
		this.sum += grassStore.getSum();
		
		FarmLand bambooFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		FarmLand grassFarm =farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		this.sum += bambooFarm.getEntitiesNum();
		this.sum += grassFarm.getEntitiesNum();
		
		
		
		//need a method to get the number of plant
		
		return sum;
		
	}
}

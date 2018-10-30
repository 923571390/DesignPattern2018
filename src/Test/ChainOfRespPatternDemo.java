package Test;

import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.BigFarmLand;
import Building.Farm;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

public class ChainOfRespPatternDemo 
{
	 public static void main(String[] args)
	 {
		 BambooStore bamboohouse = BambooStore.getInstance();
		 GrassStore grasshouse = GrassStore.getInstance();
//		 BigFarmLand grassLand = new BigFarmLand();
		 
		 bamboohouse.increase(2);
		 grasshouse.increase(3);
		 
		 Director director = new Director();
			CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
			director.setFarmBuilder(commonFarmBuilder);
			director.construct();
			Farm commonFarm = commonFarmBuilder.getFarm();
		 
		 bamboohouse.checkFeedable(commonFarm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
		 grasshouse.checkFeedable(commonFarm.getBigFarmLand().getFarmLand("Grass Farmland"));
		  
	 }
	 

}

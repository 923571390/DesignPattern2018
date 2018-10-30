package Test;

import Base.BigFarmLand;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.Farm;
import Base.SuperFarmBuilder;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.GrassStore;

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
		 SuperFarmBuilder superFarmBuilder = new SuperFarmBuilder();
		 CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();

		 director.setFarmBuilder(superFarmBuilder);
		 director.construct();
		 Farm superFarm = superFarmBuilder.getFarm();
		 superFarm.showFacilities();
		 System.out.println("");
		 
		 bamboohouse.checkFeedable(superFarm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
		 grasshouse.checkFeedable(superFarm.getBigFarmLand().getFarmLand("Grass Farmland"));
		  
	 }
	 

}

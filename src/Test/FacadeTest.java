package Test;

import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;
import Facade.Facade;

public class FacadeTest {

	public static void main(String[] args)
	{
		Director director = new Director();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();
		
		Facade facade = new Facade();
		
		facade.printPlantNum(commonFarm);
		facade.printBambNum(commonFarm);
		facade.printGrassNum(commonFarm);
	}

}

package Test;

import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;
import Facade.Facade;

public class FacadeDemo {

	public static void main(String[] args)
	{
		Director director = new Director();
		SuperFarmBuilder superFarmBuilder = new SuperFarmBuilder();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();

		director.setFarmBuilder(superFarmBuilder);
		director.construct();
		Farm superFarm = superFarmBuilder.getFarm();
		superFarm.showFacilities();
		System.out.println("");
		
		Facade facade = new Facade();
		
		facade.printPlantNum(superFarm);
		facade.printBambNum(superFarm);
		facade.printGrassNum(superFarm);
	}

}

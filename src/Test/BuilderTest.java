package Test;

import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;

public class BuilderTest {
	public static void main(String[] args) {
		Director director = new Director();
		SuperFarmBuilder superFarmBuilder = new SuperFarmBuilder();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();

		director.setFarmBuilder(superFarmBuilder);
		director.construct();
		Farm superFarm = superFarmBuilder.getFarm();
		superFarm.showFacilities();
		System.out.println("");

		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();
		commonFarm.showFacilities();
	}
}

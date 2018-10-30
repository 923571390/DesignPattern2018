package Test;

import Base.BigFarmLand;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.Facility;
import Base.Farm;
import Base.FarmLand;
import Base.Fence;
import Base.House;
import Base.SuperFarmBuilder;
import Base.YellowWall;
import AbAnimalstractFactory.*;

public class BuilderTest {

	public static void main(String[] args) {
		BuilderTest test = new BuilderTest();
//		test.testDecorator();
//		test.testFlyweight();
		test.testBuilder();
	}

	public void testDecorator() {
		House<Rhizomy> RhizomysHouse = new House<Rhizomy>("Rhizomys House", 30);
		RhizomysHouse.getDescription();

		System.out.println("");

		Facility whiteRhizomysHouse = new YellowWall(new House<Rhizomy>("Rhizomys House", 30));
		whiteRhizomysHouse.getDescription();

		System.out.println("");

		FarmLand bambooFarmland = new FarmLand("Bamboo Farmland", 100);
		bambooFarmland.getDescription();

		System.out.println("");

		Facility bambooLandFence = new Fence(new FarmLand("Bamboo Farmland", 100));
		bambooLandFence.getDescription();
	}

	public void testFlyweight() {
		String[] name = { "Bamboo Farmland", "Grass Farmland" };
		int[] capacity = { 100, 300 };
		BigFarmLand bigFarmLand = new BigFarmLand(2, name, capacity);

		FarmLand[] farmLands = bigFarmLand.getFarmLands();
		for (FarmLand farmLand : farmLands) {
			System.out.println(
					"farmLand name: " + farmLand.getName() + "   farmLand capacity: " + farmLand.getCapacity());
		}
	}

	public void testBuilder() {
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

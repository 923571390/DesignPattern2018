package Test;

import Animal.Rhizomy;
import Base.CommonFarmBuilder;
import Base.Director;
import Building.Facility;
import Building.Farm;
import Building.FarmLand;
import Building.Fence;
import Building.House;
import Building.WhiteWall;

public class DecoratorTest {
	public static void main(String[] args) {
		Director director = new Director();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();

		House<Rhizomy> RhizomysHouse = commonFarm.getRhizomysHouse();
		RhizomysHouse.getDescription();

		System.out.println("");

		Facility whiteRhizomysHouse = new WhiteWall(RhizomysHouse);
		whiteRhizomysHouse.getDescription();

		System.out.println("");

		FarmLand bambooFarmland = commonFarm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		bambooFarmland.getDescription();

		System.out.println("");

		Facility bambooLandFence = new Fence(bambooFarmland);
		bambooLandFence.getDescription();
	}
}

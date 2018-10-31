package Base;

import Animal.Cow;
import Animal.Rhizomy;
import Building.BigFarmLand;
import Building.Farm;
import Building.House;

public class CommonFarmBuilder extends FarmBuilder {

	public CommonFarmBuilder() {
		farm = new Farm("CommonFarm");
	}

	/**
	 * 为锟斤拷通农锟斤拷锟斤拷锟斤拷锟绞�
	 */
	@Override
	public void buildFacilities() {
		farm.setRhizomysHouse(new House<Rhizomy>("Rhizomys House", 50));
		farm.setCowshed(new House<Cow>("Cowshed", 30));

		String[] landName = { "Bamboo Farmland", "Grass Farmland" };
		int[] landCapacity = { 100, 300 };
		farm.setBigFarmLand(new BigFarmLand(2, landName, landCapacity));
	}
}

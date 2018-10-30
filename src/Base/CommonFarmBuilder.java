package Base;

import AbAnimalstractFactory.Cow;
import AbAnimalstractFactory.Rhizomy;

public class CommonFarmBuilder extends FarmBuilder {

	public CommonFarmBuilder() {
		farm = new Farm("CommonFarm");
	}

	/**
	 * 为锟斤拷通农锟斤拷锟斤拷锟斤拷锟绞�
	 */
	@Override
	public void buildFacilities() {
		farm.setRhizomysHouse(new House<Rhizomy>("Rhizomys House one", 50));
		farm.setCowshed(new House<Cow>("Cowshed", 30));

		String[] landName = { "Bamboo Farmland", "Grass Farmland" };
		int[] landCapacity = { 100, 300 };
		farm.setBigFarmLand(new BigFarmLand(2, landName, landCapacity));
	}
}

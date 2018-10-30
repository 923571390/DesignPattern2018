package Base;

import Animal.Cow;
import Animal.Rhizomy;
import Building.BigFarmLand;
import Building.Farm;
import Building.House;
import Building.Pool;

public class SuperFarmBuilder extends FarmBuilder {

	public SuperFarmBuilder() {
		farm = new Farm("SuperFarm");
	}

	/**
	 * 为锟斤拷锟斤拷农锟斤拷锟斤拷锟斤拷锟绞�
	 */
	@Override
	public void buildFacilities() {
		farm.setRhizomysHouse(new House<Rhizomy>("Rhizomys House one", 50));
		farm.setCowshed(new House<Cow>("Cowshed", 30));
		farm.setPool(new Pool("Pool", 150));

		String[] landName = { "Bamboo Farmland", "Grass Farmland" };
		int[] landCapacity = { 100, 300 };
		farm.setBigFarmLand(new BigFarmLand(2, landName, landCapacity));
	}
}

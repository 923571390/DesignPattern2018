package Test;

import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;
import SecurityGuard.StoreHouseGuardian;

public class ProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoreHouseGuardian guardian = new StoreHouseGuardian("guardian", 0);
		guardian.setAlarm();
		
		Director director = new Director();
		SuperFarmBuilder superFarmBuilder = new SuperFarmBuilder();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();

		director.setFarmBuilder(superFarmBuilder);
		director.construct();
		Farm superFarm = superFarmBuilder.getFarm();
		superFarm.showFacilities();
		System.out.println("");
		
		guardian.checkFeedable(superFarm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
		
	}

}

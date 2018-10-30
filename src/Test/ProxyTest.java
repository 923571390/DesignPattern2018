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
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();
		
		guardian.checkFeedable(commonFarm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
		
	}

}

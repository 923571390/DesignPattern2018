package SecurityGuard;

import java.util.Vector;

import Building.FarmLand;
import StoreHouse.BambooStore;
import StoreHouse.StoreHouse;

public class StoreHouseGuardian extends StoreHouse {
	
	public StoreHouseGuardian(String name, int capacity) {
		super(name, capacity);
	}

	private BambooStore store = BambooStore.getInstance();
	private boolean alarm = false;

	
	public void setAlarm() {
		this.alarm = !this.alarm;
	}
	
	private boolean preCheck() {
		return !this.alarm;
	}

	@Override
	public boolean checkFeedable(FarmLand land) {
		if(preCheck()) {
			return store.checkFeedable(land);
		}
		else {
			System.out.println("The farm is currently on alert! Action not allowed.");
			return false;
		}
		
	}

}

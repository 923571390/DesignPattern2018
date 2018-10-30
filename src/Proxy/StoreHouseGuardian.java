package Proxy;

import java.util.Vector;

import Base.FarmLand;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.StoreHouse;

public class StoreHouseGuardian extends StoreHouse {
	
	public StoreHouseGuardian(String name, int capacity) {
		super(name, capacity);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		if(preCheck()) {
			return store.checkFeedable(land);
		}
		else {
			System.out.println("当前处于警戒状态！不允许检查库存供给量！");
			return false;
		}
		
	}

}

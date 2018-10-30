package Plant;

import Building.FarmLand;

public abstract class Observer {

	protected FarmLand farmLand;
	public abstract void update();

}

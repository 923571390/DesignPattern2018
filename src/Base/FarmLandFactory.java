package Base;
import java.util.HashMap;

import Building.FarmLand;

public class FarmLandFactory {
	private static final HashMap<String, FarmLand> FarmLandMap = new HashMap<>();

	private static FarmLandFactory farmLandFactory;

	public static FarmLandFactory getInstance() {
		farmLandFactory = new FarmLandFactory();
		return farmLandFactory;
	}

	public synchronized FarmLand getFarmLand(String name, int capacity) {
		FarmLand farmLand = (FarmLand) FarmLandMap.get(name);
		if (null == farmLand) {
			farmLand = new FarmLand(name, capacity);
			FarmLandMap.put(name, farmLand);
		}
		return farmLand;
	}
}

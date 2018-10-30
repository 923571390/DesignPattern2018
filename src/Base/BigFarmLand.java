package Base;

import Action.VisitorAction;

public class BigFarmLand{
	private FarmLand[] farmLands;

	public BigFarmLand(int landNum, String[] name, int[] capacity) {
		farmLands = new FarmLand[landNum];
		FarmLandFactory farmLandFactory = FarmLandFactory.getInstance();

		for (int i = 0; i < farmLands.length; ++i) {
			farmLands[i] = farmLandFactory.getFarmLand(name[i], capacity[i]);
		}
	}

	public FarmLand[] getFarmLands() {
		return farmLands;
	}

	public FarmLand getFarmLand(String name) {
		for (FarmLand farmLand : farmLands) {
			if (farmLand.getName() == name) {
				return farmLand;
			}
		}
		return null;
	}
}

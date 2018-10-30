package Test;

import Base.BigFarmLand;
import Base.FarmLand;

public class FlywrightTest {
	public static void main(String[] args) {
		String[] name = { "Bamboo Farmland", "Grass Farmland" };
		int[] capacity = { 100, 300 };
		BigFarmLand bigFarmLand = new BigFarmLand(2, name, capacity);

		FarmLand[] farmLands = bigFarmLand.getFarmLands();
		for (FarmLand farmLand : farmLands) {
			System.out.println(
					"farmLand name: " + farmLand.getName() + "   farmLand capacity: " + farmLand.getCapacity());
		}
	}
}

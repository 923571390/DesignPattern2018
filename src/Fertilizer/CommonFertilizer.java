package Fertilizer;

import Enum.FertilizerType;
import Plant.Plant;

public class CommonFertilizer extends FertilizerForPlant{
	
	private static int refs = 1;
	private int id;
	private static CommonFertilizer cf = new CommonFertilizer();
	
	private CommonFertilizer() {
		addPrototype(this);
	}
	public CommonFertilizer(int d) {
		id = refs++;
	}
	@Override
	protected FertilizerType returnType() {
		return FertilizerType.COMMON;
	}

	@Override
	protected FertilizerForPlant clone() {
		return new CommonFertilizer(1);
	}
	@Override
	public String toString() {
		return "Here is a common fertilizer.";
	}
	@Override
	public void fertilizing(Plant plant) {
		plant.fertilize();
		System.out.println(plant.getType() + " have used common fertilizer.");
	}
	
}

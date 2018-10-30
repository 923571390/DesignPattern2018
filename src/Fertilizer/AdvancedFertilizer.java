package Fertilizer;

import Plant.Plant;

public class AdvancedFertilizer extends FertilizerForPlant{

	private static int refs = 1;
	private int id;
	private static AdvancedFertilizer af = new AdvancedFertilizer();
	
	private AdvancedFertilizer() {
		addPrototype(this);
	}
	public AdvancedFertilizer(int d) {
		id = refs++;
	}
	@Override
	protected FertilizerType returnType() {
		return FertilizerType.ADVANCED;
	}

	@Override
	protected FertilizerForPlant clone() {
		return new AdvancedFertilizer(1);
	}
	@Override
	public String toString() {
		return "Here is a advanced fertilizer.";
	}
	@Override
	public void fertilizing(Plant plant) {
		System.out.println(plant.getType() + " have used advanced fertilizer.");
	}
	

}

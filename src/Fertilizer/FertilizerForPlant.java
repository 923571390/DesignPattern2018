package Fertilizer;

import Plant.Plant;

//Abstraction of fertilizer for plant(use Prototype pattern)
public abstract class FertilizerForPlant {
	private static final int MAX_type_AMOUT = 10;
	private static int count = 0;
	private static FertilizerForPlant[] prototypes = new FertilizerForPlant[MAX_type_AMOUT];
	
	protected abstract FertilizerType returnType();
	
	protected abstract FertilizerForPlant clone();
	
	
	public static void addPrototype(FertilizerForPlant f) {
		prototypes[count++] = f;
	}
	
	public static FertilizerForPlant findAndClone(FertilizerType ft) {
		for(int i = 0; i < count; ++i) {
			if(prototypes[i].returnType() == ft)
				return prototypes[i].clone();
		}
		return null;
	}
	public abstract String toString();
	public abstract void fertilizing(Plant plant);

}


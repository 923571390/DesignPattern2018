package Animal;

import Plant.Grass;
import Plant.Plant;
import StoreHouse.GrassStore;

public class FactoryGroup1 implements LivingsFactory {

	private FactoryGroup1() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static FactoryGroup1 instance = new FactoryGroup1();

    public static FactoryGroup1 getInstance(){
       return instance;
    }
	
	@Override
	public Plant createPlant() {
		return new Grass();
	}

	@Override
	public Animal createAnimal() {
		return new Cow();
	}
	//This is the first concrete factory producing grosses and cows. A concrete factory can produce two kinds of products as animal and plant here. Factory method is used here as well.
}

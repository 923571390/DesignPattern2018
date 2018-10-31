package Animal;

import Plant.Bamboo;
import Plant.Plant;

public class FactoryGroup2 implements LivingsFactory {
	
	private FactoryGroup2() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static FactoryGroup2 instance = new FactoryGroup2();

    public static FactoryGroup2 getInstance(){
       return instance;
    }
	
	@Override
	public Plant createPlant() {
		return new Bamboo();
	}

	@Override
	public Animal createAnimal() {
		return new Rhizomy();
	}
		//This is the first concrete factory producing bamboos and rhizomys. A concrete factory can produce two kinds of products as animal and plant here. Factory method is used here as well.
}

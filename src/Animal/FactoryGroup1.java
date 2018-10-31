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
	//这是第一个产品族的具体工厂，用来生产牧草和奶牛，具体工厂能够生产动物和植物两类产品，采用FactoryMethodm模式。
}
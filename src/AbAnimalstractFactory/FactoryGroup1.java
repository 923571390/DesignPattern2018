package AbAnimalstractFactory;

import Plant.Grass;
import Plant.Plant;

public class FactoryGroup1 implements LivingsFactory {
	
	@Override
	public Plant createPlant() {
		// TODO Auto-generated method stub
		return new Grass();
	}

	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Cow();
	}
	//这是第一个产品族的具体工厂，用来生产牧草和奶牛，具体工厂能够生产动物和植物两类产品，采用FactoryMethodm模式。
}
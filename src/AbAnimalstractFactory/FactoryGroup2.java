package AbAnimalstractFactory;

import Plant.Bamboo;
import Plant.Plant;

public class FactoryGroup2 implements LivingsFactory {
	
	@Override
	public Plant createPlant() {
		// TODO Auto-generated method stub
		return new Bamboo();
	}

	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Rhizomy();
	}
	//这是第二个产品族的具体工厂，用来生产竹鼠和竹子
}

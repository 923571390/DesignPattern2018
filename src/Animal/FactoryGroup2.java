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
	//这是第二个产品族的具体工厂，用来生产竹鼠和竹子
}

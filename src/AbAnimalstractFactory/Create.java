package AbAnimalstractFactory;

import Base.Farm;
import Plant.Plant;

public class Create {
	
	public static Animal cow() {
		
		LivingsFactory factoryGroup1 = new FactoryGroup1();
		Animal cow = factoryGroup1.createAnimal();
		cow.create(); 
		return cow;//创建奶牛	
	}
	
	public static Plant grass(Farm farm) {
		
		LivingsFactory factoryGroup1 = new FactoryGroup1();
		Plant grass = factoryGroup1.createPlant();
		grass.create(farm); //创建牧草
		return grass;
	}
	
	public static Animal rhizomy() {
		
		LivingsFactory factoryGroup2 = new FactoryGroup2();	
		Animal rhizomy = factoryGroup2.createAnimal();
		rhizomy.create(); //创建竹鼠
		return rhizomy;
	}	
	
	public static Plant bamboo(Farm farm) {
		
		LivingsFactory factoryGroup2 = new FactoryGroup2();	
		Plant bamboo = factoryGroup2.createPlant();
		bamboo.create(farm); //创建竹子
		return bamboo;
	}
}

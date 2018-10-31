package Animal;

import Building.Farm;
import Plant.Plant;

public class Create {
	
	public static Animal cow(Farm farm) {
		
		LivingsFactory factoryGroup1 = FactoryGroup1.getInstance();
		Animal cow = factoryGroup1.createAnimal();
		cow.create(farm); 
		return cow; //创建奶牛	
	}
	
	public static Plant grass(Farm farm) {
		
		LivingsFactory factoryGroup1 = FactoryGroup1.getInstance();
		Plant grass = factoryGroup1.createPlant();
		grass.create(farm); //创建牧草
		return grass;
	}
	
	public static Animal rhizomy(Farm farm) {
		
		LivingsFactory factoryGroup2 = FactoryGroup2.getInstance();	
		Animal rhizomy = factoryGroup2.createAnimal();
		rhizomy.create(farm); //创建竹鼠
		return rhizomy;
	}	
	
	public static Plant bamboo(Farm farm) {
		
		LivingsFactory factoryGroup2 = FactoryGroup2.getInstance();	
		Plant bamboo = factoryGroup2.createPlant();
		bamboo.create(farm); //创建竹子
		return bamboo;
	}
}

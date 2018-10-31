package Animal;

import Building.Farm;
import Plant.Plant;

public class Create {
	
	public static Animal cow(Farm farm) {
		
		LivingsFactory factoryGroup1 = FactoryGroup1.getInstance();
		Animal cow = factoryGroup1.createAnimal();
		cow.create(farm); 
		return cow; 
		//create a cow
	}
	
	public static Plant grass(Farm farm) {
		
		LivingsFactory factoryGroup1 = FactoryGroup1.getInstance();
		Plant grass = factoryGroup1.createPlant();
		grass.create(farm); 
		return grass;
		//create a grass
	}
	
	public static Animal rhizomy(Farm farm) {
		
		LivingsFactory factoryGroup2 = FactoryGroup2.getInstance();	
		Animal rhizomy = factoryGroup2.createAnimal();
		rhizomy.create(farm); 
		return rhizomy;
		//create a rhizomy
	}	
	
	public static Plant bamboo(Farm farm) {
		
		LivingsFactory factoryGroup2 = FactoryGroup2.getInstance();	
		Plant bamboo = factoryGroup2.createPlant();
		bamboo.create(farm); 
		return bamboo;
		//create a bamboo
	}
}

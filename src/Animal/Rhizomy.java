package Animal;

import Building.Farm;

public class Rhizomy extends Animal{
	
	public void create(Farm farm) {
		System.out.println("Rhizomy is created!");
		farm.getRhizomysHouse().addEntity(this);
	}
	//to create a rhizomy

	@Override
	public void update() {
		
	}
}

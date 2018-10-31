package Animal;

import Building.Farm;

public class Cow extends Animal{
	//concrete product class cow
	public void create(Farm farm) {
		System.out.println("Cow is created!");
		farm.getCowshed().addEntity(this);
	}
	//to create a cow

	@Override
	public void update() {
		
	}
}

package Animal;

import Building.Farm;

public class Cow extends Animal{
	
	public void create(Farm farm) {
		System.out.println("Cow is created!");
		farm.getCowshed().addEntity(this);
	}

	@Override
	public void update() {
		
	}
}

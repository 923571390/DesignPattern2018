package Animal;

import Building.Farm;

public class Rhizomy extends Animal{
	
	public void create(Farm farm) {
		// TODO Auto-generated method stub
		System.out.println("获得竹鼠！");
		farm.getCowshed().addEntity(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}

package Building;

import Feeder.Feeder;
import Feeder.Mediator;

public class House<T> extends ConcreteFacility {

	public House(String name, int capacity) {
		super(name, capacity);
		setMediator(new Feeder());
	}

	@Override
	public void getDescription() {
		System.out.print(name);
	}
	
	public void feedAnimals(Farm farm) {
		mediator.feed(this, farm);
	}
	

	public void setMediator(Mediator mediator){
		this.mediator = mediator;
	}


}

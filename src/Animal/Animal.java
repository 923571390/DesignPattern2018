package Animal;

import AnimalState.HealthyState;
import AnimalState.State;
import AnimalState.UnhealthyState;
import Base.Entity;
import Building.Farm;

public abstract class Animal extends Entity{
	//abstract product class animal
	private State state = new HealthyState();
	private boolean full = false;
	 
	public void feed() {
		if(state.canBeFed()) { 
			heal();
			full = true;
		}
	}
	//feed the animal
	 
	public void ill() {
		this.state = new UnhealthyState();
	}
	//make it ill manually
	 
	public void heal() {
		this.state = new HealthyState();
	}
	//heal a ill animal
	 
	public void hungry() {
		this.full= false;
	}
	//make it hungry manually
	 
	public boolean isFull() {
		return full;
	}
	//check whether the animal is full
	 
	public boolean isHealthy() {
		return state.isItHealthy();
	}
	//check whether the animal is healthy

	public void create(Farm farm) {}
	
}

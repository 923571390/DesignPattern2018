package Animal;

import AnimalState.HealthyState;
import AnimalState.State;
import AnimalState.UnhealthyState;
import Base.Entity;
import Building.Farm;

public abstract class Animal extends Entity{
	
	private State state = new HealthyState();
	private boolean full = false;
	 
	public void feed() {
		if(state.canBeFed()) { 
			heal();
			full = true;
		}
	}
	 
	public void ill() {
		this.state = new UnhealthyState();
	}
	 
	public void heal() {
		this.state = new HealthyState();
	}
	 
	public void hungry() {
		this.full= false;
	}
	//具体产品类奶牛
	 
	public boolean isFull() {
		return full;
	}
	 
	public boolean isHealthy() {
		return state.isItHealthy();
	}

	public void create(Farm farm) {}
}

package AbAnimalstractFactory;

import AnimalState.HealthyState;
import AnimalState.State;
import AnimalState.UnhealthyState;
import Base.Entity;

public abstract class Animal extends Entity{
	
	private State state = new HealthyState();
	private boolean full = true;
	 
	public void feed() {
		// TODO Auto-generated method stub
		if(state.canBeFed()) { 
			heal();
			full= true;
		}

	}
	 
	public void ill() {
		// TODO Auto-generated method stub
		this.state = new UnhealthyState();
	}
	 
	public void heal() {
		// TODO Auto-generated method stub
		this.state = new HealthyState();
	}
	 
	public void hungry() {
		// TODO Auto-generated method stub
		this.full= false;
	}
//具体产品类奶牛
	 
	public boolean isFull() {
		// TODO Auto-generated method stub
		return full;
	}
	 
	public boolean isHealthy() {
		// TODO Auto-generated method stub
		return state.isItHealthy();
	}

	public void create() {
		// TODO Auto-generated method stub
		
	}
}

package Building;

import java.util.Iterator;

import Action.Acceptor;
import Action.VisitorAction;
import Base.Entity;
import Plant.Observer;
import Plant.Plant;

public class FarmLand extends ConcreteFacility implements Acceptor {

	private boolean isWet;

	public FarmLand(String name, int capacity) {
		super(name, capacity);
	}

	@Override
	public void getDescription() {
		System.out.print(name);
	}

	public boolean isWet() {
		return isWet;
	}

	public void setWet(boolean isWet) {
			
		this.isWet = isWet;
		
	}
	
	 public void attach(Entity p){
		 this.addEntity(p);
	 }
	

	public void notifyAllObservers()
	{
	      for (Observer observer : entities) 
	      {
	         observer.update();
	      }
	}

	@Override
	public void runAction(VisitorAction visitor) {
		// TODO Auto-generated method stub
		try {
			visitor.visit(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkHumidity() {
		Iterator iter = entities.iterator();
		while(iter.hasNext()) {
			if(((Plant) iter).wet()) {
				System.out.println("Humidity has not been satisfactory!");
				return false;
			}
		}
		System.out.println("Humidity has been satisfactory!");
		return true;
	}

}

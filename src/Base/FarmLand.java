package Base;

import Action.VisitorAction;
import Plant.Observer;

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
		
		boolean isChange=false;		
		if (isWet != this.isWet) isChange=true;
			
		this.isWet = isWet;
		if (isChange)
		 notifyAllObservers();
		isChange=false;
		
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

}

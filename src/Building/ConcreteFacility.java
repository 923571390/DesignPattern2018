package Building;
import java.util.ArrayList;

import Base.Entity;
import Feeder.Mediator;

public abstract class ConcreteFacility implements Facility {

	protected String name;
	// capacity
	private int capacity;

	protected ArrayList<Entity> entities;
	
	protected Mediator mediator;

	/**
	 *
	 * @param name     
	 *
	 * @param capacity 
	 */
	public ConcreteFacility(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.entities = new ArrayList<Entity>();
	}

	/**
	 * 
	 */
	@Override
	public void getDescription() {
		System.out.print(getName());
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void addEntity(Entity entity) {
		if (isFull()) {
			System.out.println("The building can not hold anymore.");
		} else {
			entities.add(entity);
		}
	}
	
	public ArrayList<Entity> getEntities(){
		return this.entities;
	}

	public void removeEntity(Entity entity) {
		if (!entities.remove(entity)) {
			System.out.println("Remove denied.");
		}
	}

	public int getEntitiesNum() {
		return entities.size();
	}

	public int getLeftCapacity() {
		return capacity - getEntitiesNum();
	}

	public boolean isFull() {
		return capacity - getEntitiesNum() <= 0;
	}
	
}

package Base;
import java.util.ArrayList;

import Mediator.Mediator;

public abstract class ConcreteFacility implements Facility {

	protected String name;
	// capacity����
	private int capacity;

	protected ArrayList<Entity> entities;
	
	protected Mediator mediator;

	/**
	 *
	 * @param name     ���������ʩ����
	 *
	 * @param capacity ����
	 */
	public ConcreteFacility(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.entities = new ArrayList<Entity>();
	}

	/**
	 * ��ȡ��װ������װ����װ�κ�ı�װ���ߵ�����
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
			System.out.println("�������㣡");
		} else {
			entities.add(entity);
		}
	}
	
	public ArrayList<Entity> getEntities(){
		return this.entities;
	}

	public void removeEntity(Entity entity) {
		if (!entities.remove(entity)) {
			System.out.println("Ŀ�겻���ڣ��Ƴ�ʧ�ܣ�");
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

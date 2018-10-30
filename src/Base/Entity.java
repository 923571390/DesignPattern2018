package Base;

import Plant.Observer;

public abstract class Entity extends Observer{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

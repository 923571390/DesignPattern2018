package Building;

public class Pool extends ConcreteFacility {
	public Pool(String name, int capacity) {
		super(name, capacity);
	}

	@Override
	public void getDescription() {
		System.out.print(name);
	}
}

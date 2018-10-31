package AnimalState;

public class HealthyState extends State {

	@Override
	public boolean canBeFed() {
		System.out.println("This animal is full now!");
		return true;
	}

	@Override
	public boolean isItHealthy() {
		return true;
	}
}

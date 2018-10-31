package AnimalState;

public class HealthyState extends State {

	@Override
	public boolean canBeFed() {
		// TODO Auto-generated method stub
		System.out.println("This animal is full now!");
		return true;
	}

	@Override
	public boolean isItHealthy() {
		// TODO Auto-generated method stub
		return true;
	}
}

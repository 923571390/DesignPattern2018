package Strategy;

public class PurchaseStrategyB implements PurchaseStrategy {

	@Override
	public void discount() {
		System.out.println("You have 30% off and a package of seeds");
	}

}

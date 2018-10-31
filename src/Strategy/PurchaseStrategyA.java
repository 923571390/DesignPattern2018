package Strategy;

public class PurchaseStrategyA implements PurchaseStrategy {

	@Override
	public void discount() {
		System.out.println("You have 10% off and a VIP card");
	}

}

package Strategy;

enum PurchaseStrategyType {
	strategyA, strategyB, strategyC
}

public class Purchase {

	private PurchaseStrategy purchaseStrategy;

	public Purchase(PurchaseStrategy purchaseStrategy) {
		this.purchaseStrategy = purchaseStrategy;
	}

	public void doPurchaseStrategy() {
		purchaseStrategy.discount();
	}
}

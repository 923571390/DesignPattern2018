package Test;

import Strategy.Purchase;
import Strategy.PurchaseStrategyA;
import Strategy.PurchaseStrategyB;
import Strategy.PurchaseStrategyC;

public class StrategyTest {

	public static void main(String[] args) {
		StrategyTest test = new StrategyTest();
		test.testStrategy();
	}
	public void testStrategy() {
		Purchase purchase;

		System.out.println("Strategy A:");
		purchase = new Purchase(new PurchaseStrategyA());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy B:");
		purchase = new Purchase(new PurchaseStrategyB());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy C:");
		purchase = new Purchase(new PurchaseStrategyC());
		purchase.doPurchaseStrategy();
	}
}

package ChainOfPesponsibility;

public class StoreHandler extends Handler
{
	private StoreHouse storeHouse;

	@Override
	public boolean getFood() {
		if (this.storeHouse.getSum()>0)
		{
			 System.out.println("Take food from the storehouse");
			 this.storeHouse.decrease(1);
			return true;
		}
		
		return false;
	}
	
	public StoreHandler(StoreHouse storeHouse)
	{
		super();
		this.storeHouse=storeHouse;
	}
	
}

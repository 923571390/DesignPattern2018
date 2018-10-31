package StoreHouse;

public class StoreHandler extends Handler
{
	private StoreHouse storeHouse;

	@Override
	public boolean getFood() {
		if (this.storeHouse.getSum()>0)//storehouse (all mature) try to get one
		{
			 System.out.println("Take food from the storehouse");
			 this.storeHouse.decrease(1);//getit!
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

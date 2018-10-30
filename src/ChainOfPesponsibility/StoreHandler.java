package ChainOfPesponsibility;

public class StoreHandler extends Handler
{
	private StoreHouse storeHouse;

	@Override
	public boolean getFood() {
		if (this.storeHouse.getSum()>0)
		{
			 System.out.println("从仓库拿取食物。");
			 this.storeHouse.decrease(1);
			return true;
		}
		
		return false;//�޷��Ӳֿ��ã���������������
	}
	
	public StoreHandler(StoreHouse storeHouse)
	{
		super();
		this.storeHouse=storeHouse;
	}


	
}

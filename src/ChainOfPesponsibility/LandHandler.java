package ChainOfPesponsibility;

import Base.FarmLand;

public class LandHandler extends Handler
{
	private FarmLand land;

	
	@Override
	public boolean getFood() {
		
		//������Ҫһ����ȡ�����Ƿ��г���ʳ��ķ���
		return false;
	}
	
	public LandHandler(FarmLand land)
	{
		super();
		this.land = land;
	}
}

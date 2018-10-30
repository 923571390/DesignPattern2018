package Base;

import Building.Farm;

public abstract class FarmBuilder {

	protected Farm farm;

	/**
	 * 
	 * @Title: buildFacilities
	 * @Description: Ϊũ�������ʩ����ͬ������builder�в�ͬ�ķ�ʽ
	 * @param
	 * @return void
	 */
	public abstract void buildFacilities();

	public Farm getFarm() {
		return farm;
	}
}

package Base;

public class Director {
	// ����ũ����Builder��������SuoerFarmBuilder��CommonFarmBuilder
	private FarmBuilder farmBuilder;

	public void setFarmBuilder(FarmBuilder farmBuilder) {
		this.farmBuilder = farmBuilder;
	}

	/**
	 * 
	 * @Title: construct
	 * @Description: ʹ�þ����Builder����ũ��
	 * @param
	 * @return void
	 */
	public void construct() {
		farmBuilder.buildFacilities();
	}
}

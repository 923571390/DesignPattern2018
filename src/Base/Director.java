package Base;

public class Director {
	private FarmBuilder farmBuilder;

	public void setFarmBuilder(FarmBuilder farmBuilder) {
		this.farmBuilder = farmBuilder;
	}

	/**
	 * 
	 * @Title: construct
	 * @Description: Builder
	 * @param
	 * @return void
	 */
	public void construct() {
		farmBuilder.buildFacilities();
	}
}

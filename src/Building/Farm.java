package Building;

import Animal.Cow;
import Animal.Rhizomy;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;

public class Farm {
	// ũ�������ͣ�������SuperFarm��CommonFarm
	private String type;
	// ������
	private House<Rhizomy> RhizomysHouse;
	// ţ��
	private House<Cow> cowshed;

//	private static Farm instance = new Farm();
//		 
//	private Farm(){}
//	 
//	   
//	public static Farm getInstance(){
//	   return instance;
//	}

	// storeHouse
	private BambooStore bambooStore = BambooStore.getInstance();
	private GrassStore grassStore = GrassStore.getInstance();

	// ����ũ���Ĵ�����
	private BigFarmLand bigFarmLand;
	// ����
	private Pool pool;

	/**
	 * 
	 * @Title: showFacilities
	 * @Description: ʹ��Builder����ũ��������ũ������Щ��ʩ
	 * @param
	 * @return void
	 */
	public void showFacilities() {
		System.out.println(getType() + ":");
		System.out.println("Rhizomys House: " + (RhizomysHouse != null ? "one" : "none"));
		System.out.println("Cowshed: " + (cowshed != null ? "one" : "none"));
		System.out.println("Bamboo Farmland: " + (bigFarmLand.getFarmLand("Bamboo Farmland") != null ? "one" : "none"));
		System.out.println("Grass Farmland: " + (bigFarmLand.getFarmLand("Grass Farmland") != null ? "one" : "none"));
		System.out.println("Pool: " + (pool != null ? "one" : "none"));
		System.out.println("Bamboo Store: " + (bambooStore != null ? "one" : "none"));
		System.out.println("Grass Store: " + (grassStore != null ? "one" : "none"));
	}

	public Farm(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public House<Rhizomy> getRhizomysHouse() {
		return RhizomysHouse;
	}

	public void setRhizomysHouse(House<Rhizomy> RhizomysHouse) {
		this.RhizomysHouse = RhizomysHouse;
	}

	public House<Cow> getCowshed() {
		return cowshed;
	}

	public void setCowshed(House<Cow> cowshed) {
		this.cowshed = cowshed;
	}

	public BambooStore getBambooStore() {
		return bambooStore;
	}

	public GrassStore getGrassStore() {
		return grassStore;
	}

	public BigFarmLand getBigFarmLand() {
		return bigFarmLand;
	}

	public void setBigFarmLand(BigFarmLand bigFarmLand) {
		this.bigFarmLand = bigFarmLand;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
}

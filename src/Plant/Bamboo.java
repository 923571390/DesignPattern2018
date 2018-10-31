package Plant;

import Building.Farm;
import Building.FarmLand;
import Fertilizer.FertilizerForPlant;

public class Bamboo extends Plant{
	private boolean isHealth = true;
    private boolean isFertilized = false;
	private boolean isWet = false;
	private boolean isMature = false;
	
	public Bamboo() {
		setType("bamboo");
	}
	@Override
	public void fertilizing() {
	    FertilizerForPlant fertilizer = getFertilizer();
	    fertilizer.fertilizing(this);
	}

	@Override
	public void create(Farm farm) {
		
		FarmLand farmLand = farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		setType("bamboo");
		System.out.println("Bamboo is created.");
		this.farmLand=farmLand;
		this.farmLand.attach(this);
	}

	@Override
	public void remove() {
		//閸掔娀娅庣粩鐟扮摍閸︿即鍣锋潻娆愶紩缁旂懓鐡�
	}

	@Override
	public void water() {
		isWet = true;
		if(isFertilized == true) maturate();
		System.out.println("Bamboo is watered.");
	}

	@Override
	public void ill() {
		isHealth = false;
	}

	@Override
	public void heal() {
		isHealth = true;
	}
    //閸忚渹缍嬫禍褍鎼х猾鑽ゎ伓鐎涳拷

	@Override
	public void fertilize() {
		isFertilized = true;
		if(isWet == true) maturate();
	}
	
	private void maturate() {
		isMature = true;
	}
	
	@Override
	public boolean healthstate() {
		return isHealth;
	}
	
	@Override
	public boolean fertilized() {
		
		return isFertilized;
	}	
	public boolean wet() {
		return isWet;
	}	
	public boolean mature() {
		
		return isMature;
	}
    public int group() {

		return 2;
	}
}

	



package Plant;

import Building.Farm;
import Building.FarmLand;
import Fertilizer.FertilizerForPlant;

public class Bamboo extends Plant{
	//concrete product class Bamboo
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
		
	}
	//remove a plant

	@Override
	public void water() {
		isWet = true;
		if(isFertilized == true) maturate();
		System.out.println("Bamboo is watered.");
	}
	//water a plant

	@Override
	public void ill() {
		isHealth = false;
	}
	//to make a plant ill manually

	@Override
	public void heal() {
		isHealth = true;
	}
	//heal an ill plant

	@Override
	public void fertilize() {
		isFertilized = true;
		if(isWet == true) maturate();
	//fertilize a plant
	
	private void maturate() {
		isMature = true;
	}
        //make a plant mature
	
	@Override
	public boolean healthstate() {
		return isHealth;
	}
	//check whether a plant is healthy
	
	@Override
	public boolean fertilized() {
		
		return isFertilized;
	}	
	//check whether a plant has been fertilized
		
	public boolean wet() {
		return isWet;
	}	
	//check whether a plant is wet
		
	public boolean mature() {
		
		return isMature;
	}
        //check whether a plant is mature
        public int group() {

		return 2;
	}
}

	



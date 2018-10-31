package Plant;

import Building.Farm;
import Building.FarmLand;
import Fertilizer.FertilizerForPlant;
public class Grass extends Plant{

	private boolean isHealth = true;
    private boolean isFertilized = false;
	private boolean isWet = false;
	private boolean isMature = false;
	
	public Grass() {
		setType("grass");
	}
	@Override
	public void fertilizing() {
		  FertilizerForPlant fertilizer = getFertilizer();
		  fertilizer.fertilizing(this);
	}

	@Override
	public void create(Farm farm) {
		FarmLand farmLand = farm.getBigFarmLand().getFarmLand("Grass Farmland");
		setType("grass");
		System.out.println("Grass is created");
		this.farmLand = farmLand;
		this.farmLand.attach(this);
	}
	@Override
	public void remove() {
	}
	@Override
	public void water() {
		isWet = true;
		if(isFertilized == true) maturate();
		System.out.println("Grass is watered.");
	}
	@Override
	public void ill() {
		isHealth = false;
	}
	@Override
	public void heal() {
		isHealth = true;
	}
	
	@Override
	public void fertilize() {
		isFertilized = true;
		if(isWet == true) maturate();
	}
	private void maturate() {
		isMature = true;
	}
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
		return 1;
	}
    
    
    
    
}



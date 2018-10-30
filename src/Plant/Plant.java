package Plant;
import Base.Entity;
import Base.Farm;
import Fertilizer.FertilizerForPlant;
public abstract class Plant extends Entity {
	
	private FertilizerForPlant fertilizer;
	private String type;
	
	public abstract void create(Farm farm);
	public abstract void remove();
	protected abstract void water();
	public abstract void ill();
	public abstract void heal();
	

	public abstract  boolean healthstate();
	public abstract boolean wet();
	public abstract boolean fertilized();
	public abstract boolean mature();
	protected abstract int group();
	
	public FertilizerForPlant getFertilizer() {
		return fertilizer;
	}
	
	public void setFertilizer(FertilizerForPlant f) {
		this.fertilizer = f;
	}
	
	public void setType(String t) {
		this.type = t;
	}
	
	public String getType() {
		return this.type;
	}
	
	public abstract void fertilizing();
	public abstract void fertilize();
	
	public void update()
	{
		water();
	}

}

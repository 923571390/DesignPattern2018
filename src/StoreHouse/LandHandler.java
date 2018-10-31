package StoreHouse;

import java.util.ArrayList;

import Base.Entity;
import Building.FarmLand;
import Plant.Plant;

public class LandHandler extends Handler
{
	private FarmLand land;

	
	@Override
	public boolean getFood() {
		
		 for (Entity plant : this.land.getEntities()) //get plants in land
	      {
	         if(((Plant) plant).mature()==true)//if plant is muture
	         {
	        	 this.land.removeEntity(plant);//getit
	        	 System.out.println("Take food from the land");
	        	 return true;
	         }
	      }
			
		return false;
	}
	
	public LandHandler(FarmLand land)
	{
		super();
		this.land = land;
	}
}

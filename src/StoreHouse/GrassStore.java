package StoreHouse;

import Building.BigFarmLand;
import Building.FarmLand;

public class GrassStore extends StoreHouse{
	
	  
	private GrassStore(String name, int capacity) {
		super(name, capacity);
		// TODO Auto-generated constructor stub
	}


	private static GrassStore instance = new GrassStore("Grass Store", 100);
	 
	 

	   public static GrassStore getInstance(){
	      return instance;
	   }

	  
	   @Override
		public boolean checkFeedable(FarmLand land) {
			Handler storeFeed = new StoreHandler(instance);
			Handler landFeed = new LandHandler(land);
			
			storeFeed.setNext(landFeed);
			
			if(storeFeed.handMessage())
			{
				return true;
			}
			System.out.println("The cow has no grass to eat.");
			return false;
	}

}

package StoreHouse;

import Building.BigFarmLand;
import Building.FarmLand;

public class BambooStore extends StoreHouse{

	private BambooStore(String name, int capacity) {
		super(name, capacity);
	}



	private static BambooStore instance = new BambooStore("Bamboo Store",100);
	 
	 
	   
   public static BambooStore getInstance(){
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
		System.out.println("Rhizomyidae have no bamboo to eat.");
		return false;
   }
	 
}

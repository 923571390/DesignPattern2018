package StoreHouse;

import Building.BigFarmLand;
import Building.FarmLand;

public class BambooStore extends StoreHouse{

	private BambooStore(String name, int capacity) {
		super(name, capacity);
	}



	private static BambooStore instance = new BambooStore("Bamboo Store",100);
	 
	 
	   
   public static BambooStore getInstance(){//Singleton 
      return instance;
   }



   //This is a function to check if there are mature plants 
   //in the storehouse or the land.
   //API of Chain of Responsibility Pattern
   @Override
	public boolean checkFeedable(FarmLand land) {
	   
		Handler storeFeed = new StoreHandler(instance);
		Handler landFeed = new LandHandler(land);
		
		storeFeed.setNext(landFeed);//Set the next object of the chain 
		//Check the warehouse first and then the land
		
		if(storeFeed.handMessage())//start to check
		{
			return true;//If can provide food ,return true
			
		}
		System.out.println("Rhizomyidae have no bamboo to eat.");
		return false;
   }
	 
}

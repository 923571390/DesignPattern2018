package ChainOfPesponsibility;

import Base.BigFarmLand;
import Base.FarmLand;

public class BambooStore extends StoreHouse{

	private BambooStore(String name, int capacity) {
		super(name, capacity);
		// TODO Auto-generated constructor stub
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

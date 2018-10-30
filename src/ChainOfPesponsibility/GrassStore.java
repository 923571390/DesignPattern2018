package ChainOfPesponsibility;

import Base.BigFarmLand;
import Base.FarmLand;

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
			System.out.println("牛已经没有草吃了！");
			return false;
	}

}

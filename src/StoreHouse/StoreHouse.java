package StoreHouse;

import Action.VisitorAction;
import Building.BigFarmLand;
import Building.ConcreteFacility;
import Building.FarmLand;


public abstract class StoreHouse extends ConcreteFacility 
{

	 public StoreHouse(String name, int capacity) {
		super(name, capacity);
	}

	private Integer sum=0;
	 
	 public abstract boolean checkFeedable(FarmLand land);
	 
	 public  int getSum(){
		 return this.sum;
	 }
	 
	 public int increase(int count)//Increase inventory
	 {
		 this.sum+=count;
		 System.out.println("Stock in the storehouse has increased");
		 this.printSum();
		 return this.sum;
	 }
	 
	 public boolean decrease(int count){//decrease inventory
		 if(count>sum)return false;
		 this.sum-=count;
		 System.out.println("Stock in the storehouse has decreased");
		 this.printSum();
		 return true;
	 }
	 
	 public void printSum()
	 {
		 System.out.println("Now the stock is");
		 System.out.println(this.sum);
		 
	 }
	 
	
}

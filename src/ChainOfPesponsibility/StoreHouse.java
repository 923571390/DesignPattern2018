package ChainOfPesponsibility;

import Base.BigFarmLand;
import Base.ConcreteFacility;
import Base.FarmLand;

//import Action.VisitorAction;
//import Base.Acceptor;

public abstract class StoreHouse extends ConcreteFacility //extends Acceptor
{

	 public StoreHouse(String name, int capacity) {
		super(name, capacity);
		// TODO Auto-generated constructor stub
	}

	private Integer sum=0;
	 
	 public abstract boolean checkFeedable(FarmLand land);
	 
	 public  int getSum(){
		 return this.sum;
	 }
	 
	 public int increase(int count)
	 {
		 this.sum+=count;
		 System.out.println("仓库储量增加。");
		 this.printSum();
		 return this.sum;
	 }
	 
	 public boolean decrease(int count){
		 if(count>sum)return false;
		 this.sum-=count;
		 System.out.println("仓库储量减少。");
		 this.printSum();
		 return true;
	 }
	 
	 public void printSum()
	 {
		 System.out.println("仓库储存量总数为：");
		 System.out.println(this.sum);
		 
	 }
	 
//	 @Override
//	 public void runAction(VisitorAction visitor) {
//			// TODO Auto-generated method stub
//			try {
//				visitor.visit(this);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	 
	
}

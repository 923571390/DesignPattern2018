package StoreHouse;

public abstract class Handler {

	 private Handler nextHandler = null;
	 
	 //handMessage()->getFood()istrue->return true
	 //                          false->goto next  (no next ->return false        
	 public final boolean handMessage()//this is a chain
	 {
		 if(this.getFood())//check a Handler  
		 {
			 return true;
		 }
			
		 else{//if this handler getfood is false ,goto next
			 if (nextHandler != null) {
	                return nextHandler.handMessage();
	            } else {
	                
	            	return false;
	            }
			}
	 }
	 
	 public void setNext(Handler handler){
	        this.nextHandler = handler;
	    }
	 
	 public abstract boolean getFood() ;//There is a difference between Handler
	 
}

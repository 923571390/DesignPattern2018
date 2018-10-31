package StoreHouse;

public abstract class Handler {

	 private Handler nextHandler;
	 
	 public final boolean  handMessage()
	 {
		 if(this.getFood())
		 {
			 return true;
		 }
			
		 else{
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
	 
	 public abstract boolean getFood() ;
	 
}

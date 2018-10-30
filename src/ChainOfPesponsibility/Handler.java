package ChainOfPesponsibility;

public abstract class Handler {

	 private Handler nextHandler;
	 
	 public final boolean  handMessage()//处理成功返回true 
	 {
		 if(this.getFood())
		 {
			 return true;
		 }
			// 切换到下一个节点处理
		 else{
			 if (nextHandler != null) {
	                return nextHandler.handMessage();
	            } else {
	                // 没有适当的处理者，业务自行处理
	            	return false;
	            }
			}
	 }
	 
	 public void setNext(Handler handler){
	        this.nextHandler = handler;
	    }
	 
	 public abstract boolean getFood() ;
	 
}

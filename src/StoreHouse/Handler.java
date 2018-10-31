package StoreHouse;

public abstract class Handler {

	 private Handler nextHandler = null;
	 
	 public final boolean  handMessage()//����ɹ�����true 
	 {
		 if(this.getFood())
		 {
			 return true;
		 }
			// �л�����һ���ڵ㴦��
		 else{
			 if (nextHandler != null) {
	                return nextHandler.handMessage();
	            } else {
	                // û���ʵ��Ĵ����ߣ�ҵ�����д���
	            	return false;
	            }
			}
	 }
	 
	 public void setNext(Handler handler){
	        this.nextHandler = handler;
	    }
	 
	 public abstract boolean getFood() ;
	 
}

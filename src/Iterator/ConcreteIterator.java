package Iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{
	
	private List<Object> list = new ArrayList<Object>();
	private int cursor = 0;
	
	public ConcreteIterator(List<Object> list){
		this.list = list;
	}
	
	public boolean hasNext() {
		if(cursor == list.size()){
			return false;
		}
		
		return true;
	}
	
	public Object next() {
		Object obj = null;
		if(this.hasNext()){
			obj = this.list.get(cursor++);
		}
		
		return obj;
	}
}



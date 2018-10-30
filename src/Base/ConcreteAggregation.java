package Base;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregation implements Aggregation {
	
	private List<Object> list = new ArrayList<Object>();
	
	public void add(Object obj) {
		list.add(obj);
	}
 
	public Iterator iterator() {
		return new ConcreteIterator(list);
	}
 
	public void remove(Object obj) {
		list.remove(obj);
	}
}

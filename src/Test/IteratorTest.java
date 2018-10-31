package Test;

import Iterator.ConcreteAggregation;
import Iterator.Iterator;

public class IteratorTest {

	public static void main(String[] args) {

		ConcreteAggregation list = new ConcreteAggregation();
        list.add("abc");
        list.add("edf");
        list.add("ghi");
        for(Iterator it= list.iterator();it.hasNext();)
        {
            System.out.println(it.next());
        }
	}

}

package Composite_Pattern;

import java.util.Iterator;
import java.util.Vector;

public class Intendant extends Person{

	private String name;
	private Vector<Person> subordinateList = new Vector<Person>();//管理者下面的员工列表
	
	public Intendant(String employeename)
	{
		this.name=employeename;
	}
	public Person add(Person person){
		subordinateList.add(person);
		return this;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public Vector<Person> getSubordinateInfo() {
        return this.subordinateList;
    }

	   protected void printList(String prefix) {  //總覽       
		   System.out.println(prefix+ " Intendant:"+this.name);         
		   Iterator<Person> it = subordinateList.iterator();         
		   while (it.hasNext()) { Person person= (Person)it.next();   
		   //Entry entry = it.next();              
		   person.printList(prefix+ " Intendant:" + this.name);         
		   }
	   }


}

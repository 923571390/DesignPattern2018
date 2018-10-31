package PersonnelDepartment;

import java.util.Iterator;
import java.util.Vector;

public class Intendant extends Person{

	private String name;
	private Vector<Person> subordinateList = new Vector<Person>();//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟皆憋拷锟斤拷斜锟�
	
	public Intendant(String employeename)
	{
		this.name=employeename;
		System.out.println("There is a farmer:"+this.name+" in the farm");
		
	}
	public Person add(Person person){
		subordinateList.add(person);
		System.out.println("Now the intendant has a subordinate:"+this.name);
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

	   protected void printList(String prefix) {  //to test
		   System.out.println(prefix+ " Intendant:"+this.name);         
		   Iterator<Person> it = subordinateList.iterator();         
		   while (it.hasNext()) { Person person= (Person)it.next();   
		   //Entry entry = it.next();              
		   person.printList(prefix+ " Intendant:" + this.name);         
		   }
	   }

}

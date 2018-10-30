package Composite_Pattern;

public abstract class Person {

	public abstract String getName();
	
	 protected abstract void printList(String prefix);  
	 public void printList() {     
		 printList("");      
	 }
	
	public Person add(Person person){
		throw new UnsupportedOperationException();//���δ�ṩ, ���ܵ���
	}
	
	
}

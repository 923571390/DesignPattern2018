package PersonnelDepartment;


public class CompositePatternDemo {
	
	 public static void main(String[] args)
	 {
		 Intendant host = new Intendant("Host");
		 Intendant managingani = new Intendant("Managingani");
		 Intendant managingpla = new Intendant("Managingpla");
		 host.add(managingani);
		 host.add(managingpla);
		 managingani.add(new Employee("Farmer1"));
		 managingani.add(new Employee("Farmer2"));
		 managingpla.add(new Employee("Farmer3"));
		 managingpla.add(new Employee("Farmer4"));
		 
		 host.printList();
		 
	 }

}

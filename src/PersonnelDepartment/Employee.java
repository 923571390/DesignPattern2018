package PersonnelDepartment;

public class Employee extends Person{

	private String name;

	
	public Employee(String employeename)
	{
		this.name=employeename;
	}
	

	@Override
	public String getName()
	{
		return this.name;
	}


	protected void printList(String prefix) 
	{
		System.out.println(prefix + " Employee:"+this.name);   
	}

	
	
	
}

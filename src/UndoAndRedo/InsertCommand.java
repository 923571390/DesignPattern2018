package UndoAndRedo;

public class InsertCommand implements Command{
	

	private String name;
	private ShoppingList sl = new ShoppingList();
	
	public InsertCommand(String n) {
		this.name = n;
	}
	public ShoppingList getSl() {
		return sl;
	}
	@Override
	public void execute() {
		sl.addGoods(name);
		System.out.println("command:" + name + " is added");
		
	}

	@Override
	public void undo() {
		sl.deleGoods();
		System.out.println("command:" + name + " is undo(be deleted)");
	}

}

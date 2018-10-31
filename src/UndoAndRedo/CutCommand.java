package UndoAndRedo;

public class CutCommand implements Command{
	private String name;
	private ShoppingList sl = new ShoppingList();
	
	public CutCommand() {
		this.name=sl.getGoods();
	}

	public ShoppingList getSl() {
		return sl;
	}
	@Override
	public void execute() {
		this.name = sl.deleGoods();
		System.out.println("command:" + name + " is deleted");
		
	}

	@Override
	public void undo() {
		sl.addGoods(name);
		System.out.println("command:" + name + " is undo(be added)");
		
	}

}

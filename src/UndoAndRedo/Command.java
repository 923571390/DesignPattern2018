package UndoAndRedo;

public interface Command {
	public void execute();
	public void undo();
	public ShoppingList getSl();

}

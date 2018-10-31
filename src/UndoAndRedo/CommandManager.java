package UndoAndRedo;


import java.util.Stack;

public class CommandManager {

	private Stack<Command> undoCommand = new Stack<Command>();
    private Stack<Command> redoCommand = new Stack<Command>();
    private Stack<Memento> memList = new Stack<Memento>();

	public void executeCommand(Command command) {
		command.execute();
		undoCommand.push(command);
		//record memento
		memList.push(command.getSl().createMemento());
		System.out.println(memList.peek().getStack());        //print list
		
		if(!redoCommand.empty()) {
			redoCommand.clear();
		}
	}
	//undo
	public void undo() {
		if(!undoCommand.empty()) {
			Command command = undoCommand.pop();
			redoCommand.push(command);
			command.undo();
			memList.pop();
			System.out.println(memList.peek().getStack());      //print list
			
		}
	}
	//redo
	public void redo() {
		if(!redoCommand.isEmpty()) {
			Command command = redoCommand.pop();
			command.execute();
			undoCommand.push(command);
			memList.push(command.getSl().createMemento());
			System.out.println(memList.peek().getStack());      //print list
		}
	}

}

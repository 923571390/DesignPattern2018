package Test;

import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class CommandMementoTest {

	public static void main(String[] args) {
		//test command
		CommandManager commandManager = new CommandManager();
		commandManager.executeCommand(new InsertCommand("bamboo"));
		commandManager.executeCommand(new InsertCommand("seed"));
		commandManager.executeCommand(new CutCommand());
		commandManager.undo();
        commandManager.undo();
        commandManager.redo();
        commandManager.redo();
	}

}

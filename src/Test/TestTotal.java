package Test;

import Fertilizer.AdvancedFertilizer;
import Fertilizer.CommonFertilizer;
import Fertilizer.FertilizerForPlant;
import Fertilizer.FertilizerType;
import Plant.Bamboo;
import Plant.Grass;
import Plant.Plant;
import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class TestTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Now we want to go to shop for shopping. Let's prepare our shoppinglist");
		
		//test command and memento
		CommandManager commandManager = new CommandManager();
		System.out.println("We want to buy one bamboo and one seed.");
		commandManager.executeCommand(new InsertCommand("bamboo"));
		commandManager.executeCommand(new InsertCommand("seed"));
		System.out.println("Now we only want one bamboo.");
		commandManager.executeCommand(new CutCommand());
		System.out.println("We regret.");		
		commandManager.undo();
		System.out.println("We regret again.");
		commandManager.redo();
		
		
		
		//have created grass and bamboo
		Plant bamboo = new Bamboo();
		Plant grass = new Grass();
		
		//test prototype and bridge
		System.out.println("We have to fertilize the plant");
		//register in prototype
		FertilizerForPlant.addPrototype(new CommonFertilizer(1));
		FertilizerForPlant.addPrototype(new AdvancedFertilizer(1));
		
		//test prototype
		FertilizerForPlant f1 = FertilizerForPlant.findAndClone(FertilizerType.COMMON);
		FertilizerForPlant f2 = FertilizerForPlant.findAndClone(FertilizerType.ADVANCED);

		
		//test bridge
		f1.fertilizing(grass);
		f1.fertilizing(bamboo);
		f2.fertilizing(bamboo);
		
		

	}

}

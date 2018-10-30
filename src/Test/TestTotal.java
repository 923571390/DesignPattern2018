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
		//test builder
		Scanner input = new Scanner(System.in);
		int choose;

		System.out.println("Initialize the farm");
		System.out.println("1.Common Farm   2.Super Farm");

		Director director = new Director();
		FarmBuilder farmBuilder = null;
		Farm farm;
		choose = input.nextInt();
		if (choose == 1) {
			farmBuilder = new CommonFarmBuilder();

		} else if (choose == 2) {
			farmBuilder = new SuperFarmBuilder();
		}
		director.setFarmBuilder(farmBuilder);
		director.construct();
		farm = farmBuilder.getFarm();
		System.out.println("Your farm now have these facilities:");
		farm.showFacilities();

		//test decorator
		System.out.println("\nNow you can decorate the Rhizomys House:\n" + "1.paint the wall white\n"
				+ "2.paint the wall yellow");
		choose = input.nextInt();
		if (choose == 1) {
			Facility whiteRhizomysHouse = new WhiteWall(farm.getRhizomysHouse());
			whiteRhizomysHouse.getDescription();
		} else if (choose == 2) {
			Facility yellowRhizomysHouse = new YellowWall(farm.getRhizomysHouse());
			yellowRhizomysHouse.getDescription();
		}
		
		//test strategy
		System.out.println("\nWhen you sale your products, you have three strategies:");
		Purchase purchase;

		System.out.println("Strategy A:");
		purchase = new Purchase(new PurchaseStrategyA());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy B:");
		purchase = new Purchase(new PurchaseStrategyB());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy C:");
		purchase = new Purchase(new PurchaseStrategyC());
		purchase.doPurchaseStrategy();
		
		
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

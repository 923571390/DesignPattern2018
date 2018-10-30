package Test;

import java.util.Scanner;

import Animal.Create;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.FarmBuilder;
import Base.SuperFarmBuilder;
import Building.Facility;
import Building.Farm;
import Building.WhiteWall;
import Building.YellowWall;
import Fertilizer.AdvancedFertilizer;
import Fertilizer.CommonFertilizer;
import Fertilizer.FertilizerForPlant;
import Fertilizer.FertilizerType;
import LawnMower.Adapter220V;
import LawnMower.ImportedLawnMower;
import LawnMower.PowerPort220V;
import Plant.Bamboo;
import Plant.Grass;
import Plant.Plant;
import SecurityGuard.StoreHouseGuardian;
import Strategy.Purchase;
import Strategy.PurchaseStrategyA;
import Strategy.PurchaseStrategyB;
import Strategy.PurchaseStrategyC;
import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class TestTotal {

	public static void main(String[] args) {
		
		boolean quit = false;
		
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
		
		// test Factory Method & Abstract Factory
		System.out.println("Let's buy some animals and plant now!");
		while(!quit) {
			System.out.println("Would you like to buy an animal or a plant? (Type Q to Quit) (A/P/Q)");
			Scanner in=new Scanner(System.in);
			String s=in.next();
			switch(s){
	    	case "A":
	    		System.out.println("Would you like to create a cow or a rhizomy? (C/R)");
	    		String s1=in.next();
	    		switch(s1){
	        	case "C":
	        		if(Create.cow() != null) System.out.println("You have created a cow successfully!");
	        	    break;
	        	case "R":
	        		if(Create.rhizomy() != null) System.out.println("You have created a rhizomy successfully!");
	        	    break;
	        	default:
	        		System.out.println("The option you entered is invalid. Please re-enter it.");
	        	    break;
	        	}
	    	    break;
	    	case "P":
	    		System.out.println("Would you like to create a grass or a bamboo? (G/B)");
	    		String s2=in.next();
	    		switch(s2){
	        	case "G":
	        		if(Create.cow() != null) System.out.println("You have created a grass successfully!");
	        	    break;
	        	case "B":
	        		if(Create.rhizomy() != null) System.out.println("You have created a bamboo successfully!");
	        	    break;
	        	default:
	        		System.out.println("The option you entered is invalid. Please re-enter it.");
	        	    break;
	        	}
	    	    break;
	    	case "Q":
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("The option you entered is invalid. Please re-enter it.");
	    	    break;
	    	} 
		}
		
		//have created grass and bamboo
		System.out.println("we plant more.");
		Plant bamboo = Create.bamboo(farm);
		Plant grass = Create.grass(farm);
		
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
		
		// test proxy
		System.out.println("Let's test the security system of our new farm.");
		StoreHouseGuardian guardian = new StoreHouseGuardian("guardian", 0);
		guardian.setAlarm();
				
		guardian.checkFeedable(farm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
				
		// test adapter
		System.out.println("There are too many weeds on the new farm!");
				
		ImportedLawnMower lawnMower = new ImportedLawnMower();
		PowerPort220V powerport = new PowerPort220V();
		lawnMower.charge110V(powerport.output220v());
				
		System.out.println("Oh! We can not use 220V at all! Let's convert it to 110V!");
				
		Adapter220V adapter = new Adapter220V();
		lawnMower.charge110V((adapter.Convert220vTo110V()));
		
		

	}

}

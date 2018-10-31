package Test;

import java.util.Scanner;

import Action.HarvestAction;
import Action.WaterAction;
import Animal.Cow;
import Animal.Create;
import Animal.Rhizomy;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.FarmBuilder;
import Base.SuperFarmBuilder;
import Building.Facility;
import Building.Farm;
import Building.FarmLand;
import Building.WhiteWall;
import Building.YellowWall;
import Facade.Facade;
import Fertilizer.AdvancedFertilizer;
import Fertilizer.CommonFertilizer;
import Fertilizer.FertilizerForPlant;
import Fertilizer.FertilizerType;
import LawnMower.Adapter220V;
import LawnMower.ImportedLawnMower;
import LawnMower.PowerPort220V;
import PersonnelDepartment.Employee;
import PersonnelDepartment.Intendant;
import Plant.Bamboo;
import Plant.Grass;
import Plant.Plant;
import SecurityGuard.StoreHouseGuardian;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;
import Strategy.Purchase;
import Strategy.PurchaseStrategyA;
import Strategy.PurchaseStrategyB;
import Strategy.PurchaseStrategyC;
import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class TestTotal {

	private static final String Bamboo = null;

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
		
		// test composite
		Intendant host = new Intendant("Host");
		Intendant managingani = new Intendant("Managing animals");
		Intendant managingpla = new Intendant("Managing plants");
		host.add(managingani); 
		host.add(managingpla);
		managingani.add(new Employee("Farmer1"));
		managingpla.add(new Employee("Farmer2"));

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
	        		if(Create.cow(farm) != null) System.out.println("You have created a cow successfully!");
	        	    break;
	        	case "R":
	        		if(Create.rhizomy(farm) != null) System.out.println("You have created a rhizomy successfully!");
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
	        		if(Create.grass(farm) != null) System.out.println("You have created a grass successfully!");
	        	    break;
	        	case "B":
	        		if(Create.bamboo(farm) != null) System.out.println("You have created a bamboo successfully!");
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
		
		// test Visitor & Observer
		System.out.println("Let's water that bamboo~");
		WaterAction visitor = new WaterAction();
		FarmLand bambooLand = farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		bambooLand.runAction(visitor);
		System.out.println("Let's check the humidity of bamboo.");
		bambooLand.checkHumidity();
		
		System.out.println("How about grass?");
		FarmLand grassLand = farm.getBigFarmLand().getFarmLand("Grass Farmland");
		grassLand.checkHumidity();
		System.out.println("Looks like we have to water the lawn as well.");
		grassLand.runAction(visitor);
		
		//have created grass and bamboo
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
		
		// test Facade
		Facade facade = new Facade();
		quit = false;
		while(!quit) {
			System.out.println("\nYou can check the number of plants:\n"+  "A.check the number of plants"
					+ " B.check the number of bamboo"+" C.check the number of Grass"+" Q.quit");
			Scanner in=new Scanner(System.in);
			String s=in.next();
			switch(s){
	    	case "A":
	    		facade.printPlantNum(farm);
	    		
	    	    break;
	    	case "B":
	    		facade.printBambNum(farm);
	    	    break;
	    	case "C":
	    		facade.printGrassNum(farm);
	    	    break;
	    	
	    	case "Q":
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("The option you entered is invalid. Please re-enter it.");
	    	    break;
	    	} 
		}
		
		// test Visitor again
		System.out.println("Now that some crops are ripe, let's harvest them.");
		HarvestAction harvestVisitor = new HarvestAction();
		GrassStore grassStore = GrassStore.getInstance();
		BambooStore bambooStore = BambooStore.getInstance();
		
		bambooStore.printSum();
		bambooLand.runAction(harvestVisitor);
		bambooStore.printSum();
		
		grassStore.printSum();
		grassLand.runAction(harvestVisitor);
		grassStore.printSum();
		
		// test Mediator & Chain Of Responsibility & State (浠撳簱鍑忓皯搴旇浼氭湁鎵撳嵃锛�)
		System.out.println("The animals are hungry too. We should feed them right away.");
		System.out.println("Ops! Some animals are sick!");
		if(farm.getCowshed().getEntitiesNum() > 0) {
			Cow cow = (Cow) farm.getCowshed().getEntities().get(0);
			cow.ill();
			farm.getCowshed().feedAnimals(farm);
		}
		else {
			System.out.println("There is no cow in the cow shed.");
		}
		
		if(farm.getRhizomysHouse().getEntitiesNum() > 0) {
			((Rhizomy) farm.getRhizomysHouse().getEntities().get(0)).ill();
			farm.getRhizomysHouse().feedAnimals(farm);
		}
		else {
			System.out.println("There is no Phizomy in the Rhizomy house.");
		}		
		
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
		
		System.out.println("Today is too fulfilling, take a rest early!");
		
	}

}
